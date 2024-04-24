package com.dp;
/*
1137. N-th Tribonacci Number

The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

TC : o(n)
SC: o(n)
 */
public class NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(4));
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        if(n<=1)
            return n;
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
