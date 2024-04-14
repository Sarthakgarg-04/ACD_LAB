package Week8;
public class TuringMachine {

    private static final char BLANK = '_';
    private static final char START_MARKER = '<';
    private static final char END_MARKER = '>';
    private char[] tape;
    private int head;
    private String state;

    public TuringMachine(String input) {
        tape = (START_MARKER + input + END_MARKER).toCharArray();
        head = 1; // Head starts at the first position after the start marker
        state = "q0"; // Initial state
    }

    public boolean processInput() {
        while (true) {
            switch (state) {
                case "q0":
                    if (tape[head] == 'a') {
                        tape[head] = BLANK;
                        moveRight();
                        state = "q1";
                    } else {
                        return false; // Reject if input does not start with 'a'
                    }
                    break;

                case "q1":
                    if (tape[head] == 'a') {
                        moveRight();
                    } else if (tape[head] == BLANK) {
                        moveRight();
                        state = "q2";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q2":
                    if (tape[head] == 'b') {
                        tape[head] = BLANK;
                        moveRight();
                        state = "q3";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q3":
                    if (tape[head] == 'b') {
                        moveRight();
                    } else if (tape[head] == BLANK) {
                        moveRight();
                        state = "q4";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q4":
                    if (tape[head] == 'c') {
                        tape[head] = BLANK;
                        moveLeft();
                        state = "q5";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q5":
                    if (tape[head] == 'c') {
                        moveLeft();
                    } else if (tape[head] == BLANK) {
                        moveLeft();
                        state = "q6";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

                case "q6":
                    if (tape[head] == 'a' || tape[head] == START_MARKER) {
                        moveRight();
                        state = "q0";
                    } else {
                        return false; // Reject if unexpected symbol
                    }
                    break;

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
        String input = "abc";
        TuringMachine tm = new TuringMachine(input);
        try {
            if (tm.processInput()) {
                System.out.println("Accepted");
            } else {
                System.out.println("Rejected");
            }
        } catch (RuntimeException e) {
            System.out.println("Rejected");
        }
    }
}

