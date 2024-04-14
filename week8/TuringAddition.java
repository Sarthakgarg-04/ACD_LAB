package Week8;
public class TuringAddition {

    private static final char BLANK = '_';
    private static final char START_MARKER = '<';
    private static final char END_MARKER = '>';
    private char[] tape;
    private int head;
    private String state;

    public TuringAddition(String input1, String input2) {
        tape = (START_MARKER + input1 + "+" + input2 + END_MARKER).toCharArray();
        head = 1; // Head starts at the first position after the start marker
        state = "q0"; // Initial state
    }

    public boolean processInput() {
        while (true) {
            switch (state) {
                case "q0":
                    if (tape[head] == '1') {
                        moveRight();
                        state = "q1";
                    } else if (tape[head] == '+') {
                        moveRight();
                        state = "q4";
                    } else {
                        return false; // Reject if input does not start with '1'
                    }
                    break;

                case "q1":
                    if (tape[head] == '1') {
                        moveRight();
                    } else if (tape[head] == '+') {
                        moveRight();
                        state = "q2";
                    } else if (tape[head] == BLANK) {
                        tape[head] = BLANK;
                        state = "q_done";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q2":
                    if (tape[head] == '1') {
                        moveRight();
                        state = "q3";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q3":
                    if (tape[head] == BLANK) {
                        tape[head] = '1';
                        moveLeft();
                        state = "q1";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q4":
                    if (tape[head] == '1') {
                        moveRight();
                        state = "q5";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q5":
                    if (tape[head] == '1') {
                        moveRight();
                    } else if (tape[head] == BLANK) {
                        tape[head] = BLANK;
                        state = "q_done";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q_done":
                    return true; // Accept if the addition is completed

                default:
                    return false; // Reject if in an invalid state
            }
        }
    }

    private void moveRight() {
        head++;
        if (head == tape.length) {
            extendTape();
        }
    }

    private void moveLeft() {
        head--;
        if (head < 0) {
            reject(); // Reject if head moves to the left of the start marker
        }
    }

    private void extendTape() {
        char[] newTape = new char[tape.length * 2];
        System.arraycopy(tape, 0, newTape, 0, tape.length);
        for (int i = tape.length; i < newTape.length; i++) {
            newTape[i] = BLANK;
        }
        tape = newTape;
    }

    private void reject() {
        throw new RuntimeException("Rejected");
    }

    public static void main(String[] args) {
        String input1 = "11111"; // Representing the first number as a sequence of '1's
        String input2 = "1111"; // Representing the second number as a sequence of '1's
        TuringAddition tm = new TuringAddition(input1, input2);
        try {
            if (tm.processInput()) {
                System.out.println("Addition Result: " + tm.getAdditionResult());
            } else {
                System.out.println("Rejected");
            }
        } catch (RuntimeException e) {
            System.out.println("Rejected");
        }
    }

    public String getAdditionResult() {
        // Extract the addition result from the tape
        StringBuilder result = new StringBuilder();
        for (char symbol : tape) {
            if (symbol != START_MARKER && symbol != END_MARKER && symbol != BLANK && symbol != '+') {
                result.append(symbol);
            }
        }
        return result.toString();
    }
}
