package com.stack;

import java.util.*;

/*
1096. Brace Expansion II

Under the grammar given below, strings can represent a set of lowercase words. Let R(expr) denote the set of words the expression represents.

The grammar can best be understood through simple examples:

Single letters represent a singleton set containing that word.
R("a") = {"a"}
R("w") = {"w"}
When we take a comma-delimited list of two or more expressions, we take the union of possibilities.
R("{a,b,c}") = {"a","b","c"}
R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
Formally, the three rules for our grammar:

For every lowercase letter x, we have R(x) = {x}.
For expressions e1, e2, ... , ek with k >= 2, we have R({e1, e2, ...}) = R(e1) ∪ R(e2) ∪ ...
For expressions e1 and e2, we have R(e1 + e2) = {a + b for (a, b) in R(e1) × R(e2)}, where + denotes concatenation, and × denotes the cartesian product.
Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.



Example 1:

Input: expression = "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]

TC : o(nM)
SC: o(nM)
 */
public class BraceExpansionII {

    public static void main(String[] args) {
        System.out.println(new BraceExpansionII().braceExpansionII("{a,b}{c,{d,e}}"));
    }
    public List<String> braceExpansionII(String expression) {
        Deque<Character> op = new ArrayDeque<Character>();
        List<Set<String>> stk = new ArrayList<Set<String>>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ',') {
                // Keep popping operators from the top of the stack until the stack is empty or its top is not a multiplication sign
                while (!op.isEmpty() && op.peek() == '*') {
                    ope(op, stk);
                }
                op.push('+');
            } else if (expression.charAt(i) == '{') {
                // First determine whether a multiplication sign needs to be added, then push { onto the operator stack
                if (
                        i > 0 &&
                                (expression.charAt(i - 1) == '}' ||
                                        Character.isLetter(expression.charAt(i - 1)))
                ) {
                    op.push('*');
                }
                op.push('{');
            } else if (expression.charAt(i) == '}') {
                // Keep popping operators from the top of the stack until its top is {
                while (!op.isEmpty() && op.peek() != '{') {
                    ope(op, stk);
                }
                op.pop();
            } else {
                // First determine whether a multiplication sign needs to be added, then push the newly constructed set onto the set stack
                if (
                        i > 0 &&
                                (expression.charAt(i - 1) == '}' ||
                                        Character.isLetter(expression.charAt(i - 1)))
                ) {
                    op.push('*');
                }
                StringBuilder sb = new StringBuilder();
                sb.append(expression.charAt(i));
                stk.add(
                        new TreeSet<String>() {
                            {
                                add(sb.toString());
                            }
                        }
                );
            }
        }

        while (!op.isEmpty()) {
            ope(op, stk);
        }
        return new ArrayList<String>(stk.get(stk.size() - 1));
    }

    // Pop the operator at the top of the stack and perform the calculation
    public void ope(Deque<Character> op, List<Set<String>> stk) {
        int l = stk.size() - 2,
                r = stk.size() - 1;
        if (op.peek() == '+') {
            stk.get(l).addAll(stk.get(r));
        } else {
            Set<String> tmp = new TreeSet<String>();
            for (String left : stk.get(l)) {
                for (String right : stk.get(r)) {
                    tmp.add(left + right);
                }
            }
            stk.set(l, tmp);
        }
        op.pop();
        stk.remove(stk.size() - 1);
    }
}
