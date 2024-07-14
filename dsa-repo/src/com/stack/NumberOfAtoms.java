package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*
726. Number of Atoms

Given a string formula representing a chemical formula, return the count of each atom.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing
the name.

One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1,
no digits will follow.

For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
Two formulas are concatenated together to produce another formula.

For example, "H2O2He3Mg4" is also a formula.
A formula placed in parentheses, and a count (optionally added) is also a formula.

For example, "(H2O2)" and "(H2O2)3" are formulas.
Return the count of all elements as a string in the following form: the first name (in sorted order), followed by
its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count
(if that count is more than 1), and so on.

The test cases are generated so that all the values in the output fit in a 32-bit integer.



Example 1:

Input: formula = "H2O"
Output: "H2O"
Explanation: The count of elements are {'H': 2, 'O': 1}.
 */
public class NumberOfAtoms {

    public static void main(String[] args) {
        System.out.println(new NumberOfAtoms().countOfAtoms("H2O"));
    }
    public String countOfAtoms(String formula) {
        // Stack to keep track of the atoms and their counts
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        // Index to keep track of the current character
        int index = 0;

        // Parse the formula
        while (index < formula.length()) {
            // If left parenthesis, insert a new hashmap to the stack. It will
            // keep track of the atoms and their counts in the nested formula
            if (formula.charAt(index) == '(') {
                stack.push(new HashMap<>());
                index++;
            }
            // If right parenthesis, pop the top element from the stack
            // Multiply the count with the multiplicity of the nested formula
            else if (formula.charAt(index) == ')') {
                Map<String, Integer> currMap = stack.pop();
                index++;
                StringBuilder multiplier = new StringBuilder();
                while (
                        index < formula.length() &&
                                Character.isDigit(formula.charAt(index))
                ) {
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                if (multiplier.length() > 0) {
                    int mult = Integer.parseInt(multiplier.toString());
                    for (String atom : currMap.keySet()) {
                        currMap.put(atom, currMap.get(atom) * mult);
                    }
                }

                for (String atom : currMap.keySet()) {
                    stack
                            .peek()
                            .put(
                                    atom,
                                    stack.peek().getOrDefault(atom, 0) +
                                            currMap.get(atom)
                            );
                }
            }
            // Otherwise, it must be a UPPERCASE LETTER. Extract the complete
            // atom with frequency, and update the most recent hashmap
            else {
                StringBuilder currAtom = new StringBuilder();
                currAtom.append(formula.charAt(index));
                index++;
                while (
                        index < formula.length() &&
                                Character.isLowerCase(formula.charAt(index))
                ) {
                    currAtom.append(formula.charAt(index));
                    index++;
                }

                StringBuilder currCount = new StringBuilder();
                while (
                        index < formula.length() &&
                                Character.isDigit(formula.charAt(index))
                ) {
                    currCount.append(formula.charAt(index));
                    index++;
                }

                int count = currCount.length() > 0
                        ? Integer.parseInt(currCount.toString())
                        : 1;
                stack
                        .peek()
                        .put(
                                currAtom.toString(),
                                stack.peek().getOrDefault(currAtom.toString(), 0) +
                                        count
                        );
            }
        }

        // Sort the final map
        TreeMap<String, Integer> finalMap = new TreeMap<>(stack.peek());

        // Generate the answer string
        StringBuilder ans = new StringBuilder();
        for (String atom : finalMap.keySet()) {
            ans.append(atom);
            if (finalMap.get(atom) > 1) {
                ans.append(finalMap.get(atom));
            }
        }

        return ans.toString();
    }
}
