import java.util.*;

public class experimentfour {
    
    public static void main(String[] args) {
        // Input the grammar
        String grammar = "S -> AB | a\nA -> aA | ε\nB -> bB | ε";
        
        // Separate terminals and non-terminals
        Map<String, Integer> terminals = new HashMap<>();
        Map<String, Integer> nonTerminals = new HashMap<>();
        
        String[] rules = grammar.split("\n");
        for (String rule : rules) {
            String[] parts = rule.split("->");
            String nonTerminal = parts[0].trim();
            String[] symbols = parts[1].trim().split("\\|");
            
            nonTerminals.put(nonTerminal, nonTerminals.getOrDefault(nonTerminal, 0) + 1);
            
            for (String symbol : symbols) {
                symbol = symbol.trim();
                if (!symbol.equals("ε")) { 
                    for (char c : symbol.toCharArray()) {
                        if (Character.isLowerCase(c)) {
                            terminals.put(String.valueOf(c), terminals.getOrDefault(String.valueOf(c), 0) + 1);
                        }
                    }
                }
            }
        }
        
        // Display terminals and their counts
        System.out.println("Terminals:");
        for (Map.Entry<String, Integer> entry : terminals.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        // Display non-terminals and their counts
        System.out.println("\nNon-terminals:");
        for (Map.Entry<String, Integer> entry : nonTerminals.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
