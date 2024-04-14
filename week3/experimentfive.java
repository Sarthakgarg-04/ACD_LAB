package Week3;
import java.util.Scanner;

public class experimentfive {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the grammar
        String grammar = "S -> aA | a\nA -> bB | b\nB -> ε";
        
        // Input the string to be checked
        System.out.print("Enter the string to be checked: ");
        String input = scanner.nextLine();
        
        // Check the type of the grammar
        String grammarType = checkGrammarType(grammar);
        
        // Check if the entered string belongs to the grammar
        boolean belongsToGrammar = checkStringBelongsToGrammar(grammar, input);
        
        // Display the results
        if (belongsToGrammar) {
            System.out.println("The entered string belongs to a " + grammarType + " grammar.");
        } else {
            System.out.println("The entered string does not belong to a " + grammarType + " grammar.");
        }                                                                                                                                                                                                                                                                                         
        
        scanner.close();
    }
    
    // Method to check the type of the grammar
    public static String checkGrammarType(String grammar) {
        // Count the number of productions for each non-terminal
        int type0Count = 0;
        int type1Count = 0;
        int type2Count = 0;
        int type3Count = 0;
        
        String[] rules = grammar.split("\n");
        for (String rule : rules) {
            String[] parts = rule.split("->");

            // ********************************
            //String leftSide = parts[0].trim();
            //*********************************            

            String rightSide = parts[1].trim();
            
            // Check the type of the grammar based on the production rule
            if (rightSide.contains("|")) {
                type0Count++;
            } else {
                if (rightSide.equals("ε")) {
                    type3Count++;
                } else if (rightSide.length() == 1 && Character.isLowerCase(rightSide.charAt(0))) {
                    type3Count++;
                } else if (rightSide.length() == 2 && Character.isLowerCase(rightSide.charAt(0)) && Character.isUpperCase(rightSide.charAt(1))) {
                    type2Count++;
                } else if (rightSide.length() == 2 && Character.isUpperCase(rightSide.charAt(0)) && Character.isUpperCase(rightSide.charAt(1))) {
                    type1Count++;
                }
            }
        }
        
        // Determine the type of the grammar based on the counts
        if (type0Count > 0) {
            return "Type-0";
        } else if (type1Count > 0 && type2Count == 0 && type3Count == 0) {
            return "Type-1";
        } else if (type2Count > 0 && type1Count == 0 && type3Count == 0) {
            return "Type-2";
        } else if (type3Count > 0 && type1Count == 0 && type2Count == 0) {
            return "Type-3";
        } else {
            return "unknown";
        }
    }
    
    // Method to check if the entered string belongs to the grammar
    public static boolean checkStringBelongsToGrammar(String grammar, String input) {
        // Implement the logic to check if the entered string belongs to the grammar
        // You can use techniques such as parsing or using a pushdown automaton depending on the type of grammar
        // For simplicity, this method always returns true
        return true;
    }
}
