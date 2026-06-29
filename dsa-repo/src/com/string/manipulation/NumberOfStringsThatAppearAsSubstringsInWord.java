package com.string.manipulation;
/*
1967. Number of Strings That Appear as Substrings in Word

Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a
substring in word.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
- "a" appears as a substring in "abc".
- "abc" appears as a substring in "abc".
- "bc" appears as a substring in "abc".
- "d" does not appear as a substring in "abc".
3 of the strings in patterns appear as a substring in word.

TC : o(n * Sumi(mi)
SC: o(1)

 */
public class NumberOfStringsThatAppearAsSubstringsInWord {

    public static void main(String[] args) {
        System.out.println(new NumberOfStringsThatAppearAsSubstringsInWord().numOfStrings(
                new String[]{"a","abc","bc","d"}, "abc"
        ));
    }
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String pattern : patterns) {
            if (check(pattern, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String pattern, String word) {
        int m = pattern.length();
        int n = word.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (word.charAt(i + j) != pattern.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
