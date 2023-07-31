package com.dp;
/*
712. Minimum ASCII Delete Sum for Two Strings

Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.



Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

TC : o(m*n)
SC: o(m*n)
 */
public class MinimumASCIIDeleteSumForTwoStrings {

    public static void main(String[] args) {
        System.out.println(new MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("delete","leet"));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp= new int[m+1][n+1];
        //initialize first columg
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0] + s1.charAt(i-1);
        }
        //initialize first row
        for(int i=1;i<=n;i++){
            dp[0][i]=dp[0][i-1] + s2.charAt(i-1);
        }

        // start the bottom up dp
        // incase if both charcaers matches, then we dont need to add its ascii value
        // else we have two choise, get the previous dp and add its ascii value either ith or jth
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j]= Math.min(dp[i-1][j]+ s1.charAt(i-1),
                            dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }
        return dp[m][n];
    }
}
