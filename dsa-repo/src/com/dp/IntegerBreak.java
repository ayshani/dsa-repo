package com.dp;
/*
343. Integer Break

Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of
those integers.

Return the maximum product you can get.



Example 1:

Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(5));
    }
    public int integerBreak(int n) {
        if(n<=3)
            return n-1;
        Integer[] dp = new Integer[n+1];
        return util(n, dp);
    }

    private int util(int n, Integer[] dp){
        if(n<=3)
            return n;

        if(dp[n]!=null)
            return dp[n];

        int ans = n;
        for(int i=2;i<=n;i++){
            ans = Math.max(ans, i * util(n-i, dp));
        }
        return dp[n] = ans;
    }
}
