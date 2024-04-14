package Week7;

import java.util.Stack;

public class experimentfifteen {
    public static void main(String[] args) {
        String input1 = "(Well formed)"; // Example input with well-formed parentheses
        String input2 = "((Not Well formed)"; // Example input with poorly-formed parentheses

        if (accept(input1)) {
            System.out.println("The input string: \""+input1+ "\" ,has well-formed parentheses.");
        } else {
            System.out.println("The input string: \"" +input1 + "\" does not have well-formed parentheses.");
        }

        if (accept(input2)) {
            System.out.println("The input string: \"" + input2 +"\" ,has well-formed parentheses.");
        } else {
            System.out.println("The input string: \"" + input2 +"\" ,does not have well-formed parentheses.");
        }
    }

    public static boolean accept(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch); // Push opening parenthesis onto the stack
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Mismatched closing parenthesis
                } else {
                    stack.pop(); // Pop matching opening parenthesis from the stack
                }
            }
        }

        // If the stack is empty, all parentheses are well-formed
        return stack.isEmpty();
    }
}
