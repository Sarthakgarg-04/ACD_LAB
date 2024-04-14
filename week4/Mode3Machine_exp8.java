package Week4;
import java.util.ArrayList;
import java.util.List;

//Mode 3 Machine
public class Mode3Machine_exp8 {
    private List<Character> inputTape;
    private List<Character> outputTape;
    private List<Character> workTape;
    private int currentState;

    public Mode3Machine_exp8(String input) {
        inputTape = new ArrayList<>();
        outputTape = new ArrayList<>();
        workTape = new ArrayList<>();

        // Initialize input tape
        for (char c : input.toCharArray()) {
            inputTape.add(c);
        }

        // Initialize output and work tapes with blank symbols
        for (int i = 0; i < inputTape.size(); i++) {
            outputTape.add('_');
            workTape.add('_');
        }

        currentState = 0; // Start state
    }

    public void run() {
        int currentPosition = 0;

        // Run until the machine halts
        while (currentState != -1) {
            char currentSymbol = inputTape.get(currentPosition);
            int nextState = transition(currentSymbol);

            // Write to output tape if necessary
            if (currentState == 1 && nextState == 2) {
                outputTape.set(currentPosition, 'X'); // Example output action
            }

            // Move to the next position or halt if nextState is -1
            if (nextState != -1) {
                currentState = nextState;
                currentPosition++;
            } else {
                break; // Halt
            }
        }
    }

    // Define the transition function
    private int transition(char symbol) {
        switch (currentState) {
            case 0: // State 0
                if (symbol == '0') {
                    return 1;
                } else {
                    return -1; // Halt
                }
            case 1: // State 1
                if (symbol == '1') {
                    return 2;
                } else {
                    return -1; // Halt
                }
            case 2: // State 2
                if (symbol == '1') {
                    return -1; // Halt
                } else {
                    return 0; // Go back to State 0
                }
            default:
                return -1; // Halt for all other states
        }
    }

    public List<Character> getOutputTape() {
        return outputTape;
    }

    public static void main(String[] args) {
        String input = "0101110101"; // Example input
        Mode3Machine_exp8 machine = new Mode3Machine_exp8 (input);
        machine.run();

        // Print output tape
        List<Character> outputTape = machine.getOutputTape();
        System.out.println("Output Tape:");
        for (char c : outputTape) {
            System.out.print(c + " ");
        }
    }
}
