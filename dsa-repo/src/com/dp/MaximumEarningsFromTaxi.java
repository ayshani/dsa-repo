package com.dp;

import java.util.Arrays;

/*
 * 2008. Maximum Earnings From Taxi
 *
 * There are n points on a road you are driving your taxi on.
 *  The n points on the road are labeled from 1 to n in the direction you are going,
 *   and you want to drive from point 1 to point n to make money by picking up passengers.
 * You cannot change the direction of the taxi.
 *
 * The passengers are represented by a 0-indexed 2D integer array rides, where rides[i] = [starti, endi, tipi]
 * denotes the ith passenger requesting a ride from point starti to point endi
 * who is willing to give a tipi dollar tip.
 *
 * For each passenger i you pick up, you earn endi - starti + tipi dollars.
 *  You may only drive at most one passenger at a time.
 *
 * Given n and rides, return the maximum number of dollars you can earn by picking up the passengers optimally.
 *
 * Note: You may drop off a passenger and pick up a different passenger at the same point.
 *
 * Example 2:

Input: n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
Output: 20
Explanation: We will pick up the following passengers:
- Drive passenger 1 from point 3 to point 10 for a profit of 10 - 3 + 2 = 9 dollars.
- Drive passenger 2 from point 10 to point 12 for a profit of 12 - 10 + 3 = 5 dollars.
- Drive passenger 5 from point 13 to point 18 for a profit of 18 - 13 + 1 = 6 dollars.
We earn 9 + 5 + 6 = 20 dollars in total.

Logic
------------------

think it as a DP problem.
- sort the array according to start i
have a dp[n+1]
iterate over 1-n
	get the consecutive max from dp[i-1], dp[i]
	match rides[startj] == i
		update dp[endj] to have max

TC  : o(n)
SC : o(n)
*/
public class MaximumEarningsFromTaxi {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] nums = new int[][] {
                {1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}
        };
        int n  = 20;
        MaximumEarningsFromTaxi obj = new MaximumEarningsFromTaxi();
        System.out.println(obj. maxTaxiEarnings(n, nums) );
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a, b)-> a[0]-b[0]);

        long[] dp = new long[n+1];
        int j=0;
        for(int i=1;i<=n;i++){
            dp[i] =  Math.max(dp[i],dp[i-1]);
            while(j<rides.length && rides[j][0]==i){
                dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i]+ rides[j][1]-rides[j][0]+ rides[j][2]);
                j++;
            }
        }

        return dp[n];
    }

}

