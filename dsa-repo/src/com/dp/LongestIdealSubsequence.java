package com.dp;
/*
2370. Longest Ideal Subsequence

You are given a string s consisting of lowercase letters and an integer k. We call a string t ideal if the
following conditions are satisfied:

t is a subsequence of the string s.
The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
Return the length of the longest ideal string.

A subsequence is a string that can be derived from another string by deleting some or no characters without
changing the order of the remaining characters.

Note that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of 'a'
and 'z' is 25, not 1.



Example 1:

Input: s = "acfgbd", k = 2
Output: 4
Explanation: The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.
TC : o(n*26)
SC: o(26)
 */
public class LongestIdealSubsequence {

    public static void main(String[] args) {
        System.out.println(new LongestIdealSubsequence().longestIdealString("acfgbd",2));
    }
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[26];
        int res =0;
        // Updating dp with the i-th character
        for(int i=0;i<n;i++){
            int cur = s.charAt(i) -'a';
            int best =0;
            /*
            get the length of any previous subsequence ending with the previous character
            and choose the longest one
             */
            for(int prev =0; prev <26; prev++){
                if(Math.abs(prev-cur)<=k){
                    best = Math.max(best, dp[prev]);
                }
            }
            // Appending s[i] to the previous longest ideal subsequence allowed
            dp[cur] = Math.max( dp[cur], best +1);
            res = Math.max(res, dp[cur]);
        }
        return res;
    }
}
