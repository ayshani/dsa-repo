package com.dp;
/*
1043. Partition Array for Maximum Sum

Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

TC : o(n*k)
SC: o(n)
 */
public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        System.out.println(new PartitionArrayForMaximumSum()
                .maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        return util(arr, k, dp,0);
    }

    private int util(int[] arr, int k, Integer[] dp, int start){
        if(start>=arr.length)
            return 0;
        if(dp[start]!= null)
            return dp[start];

        int curMax =0, ans =0;
        int n = Math.min(arr.length, start+k);
        for(int i=start;i<n;i++){
            curMax = Math.max(arr[i],curMax);
            ans = Math.max(ans, curMax*(i-start+1) + util(arr, k, dp, i+1));
        }

        return dp[start] = ans;
    }
}
