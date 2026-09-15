package com.dp;
/*
2472. Maximum Number of Non-overlapping Palindrome Substrings

You are given a string s and a positive integer k.

Select a set of non-overlapping substrings from the string s that satisfy the following conditions:

The length of each substring is at least k.
Each substring is a palindrome.
Return the maximum number of substrings in an optimal selection.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "abaccdbbd", k = 3
Output: 2
Explanation: We can select the substrings underlined in s = "abaccdbbd". Both "aba" and "dbbd" are palindromes and
have a length of at least k = 3.
It can be shown that we cannot find a selection with more than two valid substrings.

TC : o(n^2)
SC: o(n^2)
 */
public class MaximumNumberOfNonOverlappingPalindromeSubstrings {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfNonOverlappingPalindromeSubstrings().maxPalindromes("abaccdbbd", 3));
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int len = 1; len <= n; ++len) {
            for (int left = 0; left + len <= n; ++left) {
                int right = left + len - 1;
                isPalindrome[left][right] =
                        s.charAt(left) == s.charAt(right) &&
                                (len <= 2 || isPalindrome[left + 1][right - 1]);
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            for (int j = 0; j + k <= i; ++j) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}
