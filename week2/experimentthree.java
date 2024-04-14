import java.util.Scanner;

public class experimentthree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of Java keywords
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};

        System.out.print("Enter a string: ");
        String input = scanner.next();

        // Convert the input string to lowercase for case-insensitive comparison
        String inputLowercase = input.toLowerCase();

        boolean isKeyword = false;
        int keywordCount = 0;

        for (String keyword : keywords) {
            if (inputLowercase.equals(keyword)) {
                isKeyword = true;
                keywordCount++;
                break;
            }
        }

        if (isKeyword) {
            System.out.println(input + " is a Java keyword.");
        } else {
            System.out.println(input + " is not a Java keyword.");
        }

        System.out.println("Number of keywords: " + keywordCount);

        scanner.close();
    }
}
