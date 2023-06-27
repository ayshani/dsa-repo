package com.dp;
/*
746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

TC : o(n)
SC: o(n)
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = new int[]{10,15,20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+ cost[i-1], dp[i-2]+ cost[i-2]);
        }

        return dp[n];
    }
}
