package Week1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class experimentone {
    public static void main(String[] args) {
        String filename = "C:\\Users\\91997\\Downloads\\ACD Lab\\Week1\\sample1.txt ";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int charCount = 0;
            int wordCount = 0;
            int spaceCount = 0;
            int newlineCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                charCount += line.length();
                wordCount += line.split("\\s+").length;
                spaceCount += line.chars().filter(Character::isWhitespace).count();
                newlineCount++;
            }

            System.out.println("Character count: " + charCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Whitespace count: " + spaceCount);
            System.out.println("Newline count: " + newlineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
