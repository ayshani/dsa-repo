package com.dp;
/*
5. Longest Palindromic Substring

Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

TC : o(n^2)
SC: o(n^2)
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("baabd"));
    }
    public String longestPalindrome(String s) {
        String res = "";

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int gap =0;gap<n;gap++){
            for(int i=0, j = gap; j<n;i++,j++){
                if(gap==0)
                    dp[i][j]= true;
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]= true;
                    }
                } else{
                    if(s.charAt(i)==s.charAt(j) && dp[i + 1][j - 1]){
                        dp[i][j]= true;
                    }
                }
                if(dp[i][j]){
                    res = s.substring(i,j+1);
                }
            }

        }
        return res;
    }
}
