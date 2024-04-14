package Week7;

import java.util.Scanner;

public class experimentthirteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string containing only 0s and 1s: ");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("The input string has an equal number of 0s and 1s.");
        } else {
            System.out.println("The input string does not have an equal number of 0s and 1s.");
        }

        scanner.close();
    }

    public static boolean isBalanced(String input) {
        int count0 = 0;
        int count1 = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '0') {
                count0++;
            } else if (ch == '1') {
                count1++;
            } else {
                // Ignore non-binary characters
            }
        }

        return count0 == count1;
    }
}
