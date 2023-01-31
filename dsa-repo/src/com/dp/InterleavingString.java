package com.dp;
/*
97. Interleaving String

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m
substrings
 respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.



Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

TC : o(m*n)
SC : o(m*n)
 */
public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), p = s3.length();

        if(m+n != p)
            return false;

        boolean[][] dp = new boolean[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    dp[i][j]  = true;
                } else if( i==0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if(j==0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else{
                    dp[i][j] =  (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) ||
                                (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[m][n];
    }
}
