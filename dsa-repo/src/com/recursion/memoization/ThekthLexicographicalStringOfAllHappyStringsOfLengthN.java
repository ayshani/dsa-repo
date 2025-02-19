package com.recursion.memoization;
/*
1415. The k-th Lexicographical String of All Happy Strings of Length n

A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.



Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

TC : o(k*n * n * 2^n)
SC : o(n)
 */
public class ThekthLexicographicalStringOfAllHappyStringsOfLengthN {

    public static void main(String[] args) {
        System.out.println(new ThekthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1,3));
    }
    private void generateHappyStrings(
            int n,
            int k,
            StringBuilder currentString,
            int[] indexInSortedList,
            String[] result
    ) {
        // If the current string has reached the desired length
        if (currentString.length() == n) {
            indexInSortedList[0]++; // Increment the count of generated strings

            // If this is the k-th string, store it in the result
            if (indexInSortedList[0] == k) result[0] = currentString.toString();
            return;
        }

        // Try adding each character ('a', 'b', 'c') to the current string
        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            // Skip if the current character is the same as the last one
            if (
                    currentString.length() > 0 &&
                            currentString.charAt(currentString.length() - 1) == currentChar
            ) continue;

            currentString.append(currentChar);

            // Recursively generate the next character
            generateHappyStrings(
                    n,
                    k,
                    currentString,
                    indexInSortedList,
                    result
            );

            // If the result is found, stop further processing
            if (result[0] != null) return;

            // Backtrack by removing the last character
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder currentString = new StringBuilder();
        String[] result = new String[1];
        int[] indexInSortedList = new int[1];

        // Generate happy strings and track the k-th string
        generateHappyStrings(n, k, currentString, indexInSortedList, result);
        return result[0] == null ? "" : result[0];
    }
}