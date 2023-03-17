package com.dp;
/*
647. Palindromic Substrings

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

https://www.youtube.com/watch?v=XmSOWnL6T_I

TC : o(n^2)
SC: o(n^2)
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("0123211"));
    }
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count =0;
        for(int gap =0;gap<n;gap++){
            for(int i=0, j= gap; j<n;j++,i++){
                if(gap==0){
                    dp[i][j]= true;
                } else if(gap==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1])
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
                if(dp[i][j])
                    count++;
            }
        }
        return count;
    }
}
