package Week7;

import java.util.Stack;

public class experimentfourteen {
    public static void main(String[] args) {
        String input = "101aCa101"; // Example input string

        if (accept(input)) {
            System.out.println("The input string follows the WCWR structure.");
        } else {
            System.out.println("The input string does not follow the WCWR structure.");
        }
    }

    public static boolean accept(String input) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        char currentChar;

        // Phase 1: Push symbols of W onto the stack until the special symbol C is encountered
        while (index < input.length() && (currentChar = input.charAt(index)) != 'C') {
            stack.push(currentChar);
            index++;
        }

        // Skip the special symbol C
        index++;

        // Phase 2: Pop symbols from the stack and compare with the reverse of W
        while (!stack.isEmpty() && index < input.length()) {
            currentChar = input.charAt(index);
            char stackTop = stack.pop();

            if (currentChar != stackTop) {
                return false; // Mismatch between symbols of W and WR
            }

            index++;
        }

        // If the stack is empty and all symbols of WR are consumed, accept the input
        return stack.isEmpty() && index == input.length();
    }
}
