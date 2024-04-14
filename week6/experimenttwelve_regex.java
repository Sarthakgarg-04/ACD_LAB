package Week6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class experimenttwelve_regex {
    public static void main(String[] args) {
        // Sample names
        String[] names = {"Mr. Rajesh", "Ms. Priya", "Dr. Patel", "Mrs. Patel", "Mr. Sharma", "Ms. Khan"};

        // Regular expression pattern to match names starting with "Mr" or "Ms"
        Pattern pattern = Pattern.compile("(Mr\\.|Ms\\.)\\s+\\w+");

        // Iterate over the names and match them with the pattern
        for (String name : names) {
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.println("Match found: " + matcher.group());
            } else {
                System.out.println("No match found for: " + name);
            }
        }
    }
}
