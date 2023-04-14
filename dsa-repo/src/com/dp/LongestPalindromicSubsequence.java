package com.dp;
/*
516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

TC: o(n^2)
SC: o(n^2)
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int gap =0;gap<n;gap++){
            for(int i=0, j= gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j] = 1;
                } else if(gap==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2:1;
                } else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else{
                        dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
