package com.dp;

import java.util.Arrays;

/*
1326. Minimum Number of Taps to Open to Water a Garden

There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n.
(i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap
can water the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered
return -1.

Example 1:

Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]

TC : o(m*n)
SC: o(n)
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {

    public static void main(String[] args) {
        int[] ranges = new int[]{3,4,1,1,0,0};
        System.out.println(new MinimumNumberOfTapsToOpenToWaterAGarden().minTaps(5,ranges));
    }
    public int minTaps(int n, int[] ranges) {

        // Create an array to store the minimum number of taps needed for each position
        // each position define the min number of taps to be opened for 0-i length of the garden
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)1e9);

        // Initialize the starting position of the garden
        // for 0 length, we dont require any tap to be opened
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            // Calculate the leftmost position reachable by the current tap
            int start = Math.max(0,i-ranges[i]);
            // Calculate the rightmost position reachable by the current tap
            int end = Math.min(n,i+ranges[i]);

            for(int j=start;j<=end;j++){
                // Update with the minimum number of taps
                dp[end] = Math.min(dp[end], dp[j]+1);
            }
        }

        // Check if the garden can be watered completely
        if(dp[n]==(int)1e9) {
            // Garden cannot be watered
            return -1;
        }
        // Return the minimum number of taps needed to water the entire garden
        return dp[n];
    }
}
