package Week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class experimenttwo {
    public static void main(String[] args) {
        String filename = "C:\\Users\\91997\\Downloads\\ACD Lab\\Week1\\sample2.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String input = sb.toString().toLowerCase(); // Convert the input string to lowercase for case-insensitive comparison

            int vowelCount = 0;
            int consonantCount = 0;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (Character.isLetter(ch)) { // Check if the character is a letter
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            System.out.println("Number of vowels: " + vowelCount);
            System.out.println("Number of consonants: " + consonantCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
