package com.dp.knapsack;
/*
2742. Painting the Walls

You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to
paint n different walls respectively. There are two painters available:

A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the
paid painter is already occupied.
Return the minimum amount of money required to paint the n walls.



Example 1:

Input: cost = [1,2,3,2], time = [1,2,3,2]
Output: 3
Explanation: The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time;
meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time. Thus, the total
cost is 1 + 2 = 3.

Complexity Analysis

Given nnn as the length of cost and time,

Time complexity: O(n^2)

i ranges from 0 to n and remain ranges from n to 0. Thus, there are O(n^2) states. Each state is calculated only
once due to memoization. To calculate a state, we simply check two options paint and dontPaint, which costs O(1).

Space complexity: O(n^2)
We use some space for the recursion call stack, but it is dominated by the space used to memoize our function,
which is equal to the number of states. There are O(n^2) states.
 */
public class PaintingTheWalls {

    public static void main(String[] args) {
        System.out.println(new PaintingTheWalls().paintWalls(new int[]{2,3,4,2}, new int[]{1,1,1,1}));
    }
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        Integer[][] dp = new Integer[n][n+1];
        return util(0,n,cost,time,dp);
    }

    private int util(int i, int remain, int[] cost, int[] time, Integer[][] dp){
        if(remain<=0)
            return 0;

        if(i==cost.length)
            return (int) 1e9;

        if(null != dp[i][remain])
            return dp[i][remain];

        // we have two choice either hire paid or non paid.
        // incase of paid painter, he will remain busy for current + next time[i] time. hence
        // remain will become remain - time[i]-1 th time unit
        int paint = cost[i] + util(i+1, remain - time[i]-1, cost, time, dp);
        int notPaint = util(i+1, remain, cost, time, dp);
        return dp[i][remain] = Math.min(paint, notPaint);
    }
}
