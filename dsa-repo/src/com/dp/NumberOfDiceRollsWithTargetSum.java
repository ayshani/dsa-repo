package com.dp;

import java.util.Arrays;

/*
1155. Number of Dice Rolls With Target Sum

You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the
dice so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:

Input: n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.

TC : o(nk)
SC : o(n*target)
 */
public class NumberOfDiceRollsWithTargetSum {

    public static void main(String[] args) {
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(30,30,500));
    }
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target+1];
        for(int[] val: dp){
            Arrays.fill(val,-1);
        }

        return recursion(0,n,k,target,dp);
    }

    private int recursion(int index,int n, int k, int target, int[][] dp){
        /*
        If we reach nth row ad target is 0 that means we have got a hit
         */
        if(n==index){
            if(target==0){
                return 1;
            } else
                return 0;
        }
        // Incase target is become -ve i.e. with current face we cant get target any further
        // return 0
        if(target<0)
            return 0;
        // Incase target becomes 0 but we havent yet throw all n dices,
        // then there is no possiblity taht we can go further
        if(target==0 && index<n){
            return 0;
        }

        // If we have already computed the value just return it
        if(dp[index][target]!=-1)
            return dp[index][target];

        // Otherwise try for all 1-k combinations
        int count =0;
        for(int i=1;i<=k;i++){
            count = ((count)%mod + (recursion(index+1,n,k,target-i,dp))%mod)%mod;
        }
        // assign the count value for memoization
        dp[index][target] = count;
        return count;
    }
}
