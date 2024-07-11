package com.string.manipulation;

import java.util.Stack;

/*
1190. Reverse Substrings Between Each Pair of Parentheses

You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"

TC : o(n)
SC: o(n)
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses().reverseParentheses("(abcd)"));
    }
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> openParenthesesIndices = new Stack<>();
        int[] pair = new int[n];

        // First pass: Pair up parentheses
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openParenthesesIndices.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (
                int currIndex = 0, direction = 1;
                currIndex < n;
                currIndex += direction
        ) {
            if (s.charAt(currIndex) == '(' || s.charAt(currIndex) == ')') {
                currIndex = pair[currIndex];
                direction = -direction;
            } else {
                result.append(s.charAt(currIndex));
            }
        }
        return result.toString();
    }
}
