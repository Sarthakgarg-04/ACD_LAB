package Week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftRecursionEliminator {

    public static void main(String[] args) {
        // Define the grammar rules
        Map<Character, List<String>> grammar = new HashMap<>();
        grammar.put('A', List.of("Aa", "b", "cA"));

        // Check if the grammar is left-recursive
        System.out.println("Original Grammar:");
        printGrammar(grammar);
        boolean isLeftRecursive = isLeftRecursive(grammar, 'A');
        System.out.println("Is Left Recursive: " + isLeftRecursive);

        // Eliminate left recursion if it exists
        if (isLeftRecursive) {
            System.out.println("\nEliminating Left Recursion...");
            eliminateLeftRecursion(grammar, 'A');
            System.out.println("Modified Grammar:");
            printGrammar(grammar);
        }
    }

    public static boolean isLeftRecursive(Map<Character, List<String>> grammar, char nonTerminal) {
        List<String> productions = grammar.get(nonTerminal);
        for (String production : productions) {
            if (production.charAt(0) == nonTerminal) {
                return true;
            }
        }
        return false;
    }

    public static void eliminateLeftRecursion(Map<Character, List<String>> grammar, char nonTerminal) {
        List<String> productions = grammar.get(nonTerminal);
        List<String> nonRecursiveProductions = new ArrayList<>();
        List<String> recursiveProductions = new ArrayList<>();

        // Divide productions into recursive and non-recursive
        for (String production : productions) {
            if (production.charAt(0) == nonTerminal) {
                recursiveProductions.add(production.substring(1) + nonTerminal + "'");
            } else {
                nonRecursiveProductions.add(production + nonTerminal + "'");
            }
        }

        // Add epsilon production for new non-terminal
        nonRecursiveProductions.add("");

        // Update the grammar with new productions
        grammar.put(nonTerminal, nonRecursiveProductions);
        grammar.put(nonTerminal + '\'', recursiveProductions);

        // Add non-recursive productions for the new non-terminal
        for (String production : recursiveProductions) {
            nonRecursiveProductions.add(production + nonTerminal + "'");
        }
    }

    public static void printGrammar(Map<Character, List<String>> grammar) {
        for (Map.Entry<Character, List<String>> entry : grammar.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            List<String> productions = entry.getValue();
            for (String production : productions) {
                System.out.print(production + " | ");
            }
            System.out.println();
        }
    }
}
