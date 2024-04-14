package Week6;

import java.util.*;

public class LeftFactoringexpeleven {
    public static void main(String[] args) {
        Map<Character, List<String>> grammar = new HashMap<>();
        grammar.put('S', Arrays.asList("abAB", "aB", "aC"));
        grammar.put('A', Arrays.asList("aA", "a"));
        grammar.put('B', Arrays.asList("bB", "b"));
        grammar.put('C', Arrays.asList("cC", "c"));

        System.out.println("Original Grammar:");
        printGrammar(grammar);

        System.out.println("\nGrammar after Left Factoring:");
        removeLeftFactors(grammar);
        printGrammar(grammar);
    }

    public static void removeLeftFactors(Map<Character, List<String>> grammar) {
        Map<Character, List<String>> newGrammar = new HashMap<>();
        int count = 1;

        for (Map.Entry<Character, List<String>> entry : grammar.entrySet()) {
            char nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();

            List<String> commonPrefixes = findCommonPrefixes(productions);
            if (!commonPrefixes.isEmpty()) {
                for (String prefix : commonPrefixes) {
                    char newNonTerminal = (char) ('A' + count++);
                    List<String> newProductions = new ArrayList<>();
                    for (String production : productions) {
                        if (production.startsWith(prefix)) {
                            newProductions.add(production.substring(prefix.length()));
                        }
                    }
                    newGrammar.put(newNonTerminal, newProductions);
                    productions.removeAll(newProductions);
                    productions.add(prefix + newNonTerminal);
                }
            }
        }

        grammar.putAll(newGrammar);
    }

    public static List<String> findCommonPrefixes(List<String> productions) {
        List<String> commonPrefixes = new ArrayList<>();
        String firstProduction = productions.get(0);
        for (int i = 1; i < firstProduction.length(); i++) {
            String prefix = firstProduction.substring(0, i);
            boolean hasCommonPrefix = true;
            for (String production : productions) {
                if (!production.startsWith(prefix)) {
                    hasCommonPrefix = false;
                    break;
                }
            }
            if (hasCommonPrefix) {
                commonPrefixes.add(prefix);
            }
        }
        return commonPrefixes;
    }

    public static void printGrammar(Map<Character, List<String>> grammar) {
        for (Map.Entry<Character, List<String>> entry : grammar.entrySet()) {
            char nonTerminal = entry.getKey();
            List<String> productions = entry.getValue();
            System.out.print(nonTerminal + " -> ");
            for (String production : productions) {
                System.out.print(production + " | ");
            }
            System.out.println();
        }
    }
}
