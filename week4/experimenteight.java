package Week4;

import java.util.Scanner;

//modulo3 machine OR Mod3 machine
public class experimenteight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an input string (containing only 0s and 1s): ");
        String input = scanner.nextLine();

        if (isDivisibleBy3(input)) {
            System.out.println("The input string is divisible by 3.");
        } else {
            System.out.println("The input string is not divisible by 3.");
        }

        scanner.close();
    }

    public static boolean isDivisibleBy3(String input) {
        int countOnes = 0;

        for (char ch : input.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }

        return countOnes % 3 == 0;
    }
}
