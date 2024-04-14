package Week4;
import java.util.Scanner;

public class experimentsix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string of zeroes and ones:");
        String input = scanner.nextLine();
        
        if (acceptsThreeConsecutiveOnes(input)) {
            System.out.println(input + " is Accepted");
        } else {
            System.out.println(input + " is Rejected");
        }
        
        scanner.close();
    }
    
    public static boolean acceptsThreeConsecutiveOnes(String input) {
        // Define states
        final int START_STATE = 0;
        final int STATE_1 = 1;
        final int STATE_2 = 2;
        final int FINAL_STATE = 3;
        
        // Start with the initial state
        int currentState = START_STATE;
        
        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // Perform state transitions based on the current character
            switch (currentState) {
                case START_STATE:
                    if (currentChar == '1') {
                        currentState = STATE_1;
                    }
                    break;
                case STATE_1:
                    if (currentChar == '1') {
                        currentState = STATE_2;
                    } else {
                        currentState = START_STATE;
                    }
                    break;
                case STATE_2:
                    if (currentChar == '1') {
                        currentState = FINAL_STATE;
                    } else {
                        currentState = START_STATE;
                    }
                    break;
                case FINAL_STATE:
                    break;
            }
        }
        
        // If we ended up in the final state, return true (accepted), otherwise false (rejected)
        return currentState == FINAL_STATE;
    }
}
