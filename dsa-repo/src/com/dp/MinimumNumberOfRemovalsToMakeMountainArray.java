package com.dp;

import java.util.Arrays;

/*
1671. Minimum Number of Removals to Make Mountain Array

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array nums,
return the minimum number of elements to remove to make nums a mountain array.


Example 1:

Input: nums = [1,3,1]
Output: 0
Explanation: The array itself is a mountain array so we do not need to remove any elements.

Logic
------
Get LIS from left and right side of every element.
get the maximum LIS and subtract it from n.

TC : o(n^2)
SC : o(n)
 */
public class MinimumNumberOfRemovalsToMakeMountainArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,5,6,2,3,1};
        System.out.println(new MinimumNumberOfRemovalsToMakeMountainArray().minimumMountainRemovals(nums));
        System.out.println(new MinimumNumberOfRemovalsToMakeMountainArray().minimumMountainRemovalsV2(nums));
    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = LIS(nums);

        int[] lds = LDS(nums);

        int max =0;

        for(int i=0;i<n;i++){
            if(lis[i]!=1 && lds[i]!=1)
                max= Math.max(max,lis[i]+lds[i]-1);
        }

        return n-max;
    }

    private int[] LIS(int[] num){
        int n = num.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(num[i]>num[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        return dp;
    }

    private int[] LDS(int[] num){
        int n = num.length;
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            dp[i]=1;
            for(int j=n-1;j>i;j--){
                if(num[i]>num[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        return dp;
    }

    public int minimumMountainRemovalsV2(int[] nums) {
        int N = nums.length;

        int[] lisLength = new int[N];
        int[] ldsLength = new int[N];

        Arrays.fill(lisLength, 1);
        Arrays.fill(ldsLength, 1);

        // Stores the length of longest increasing subsequence that ends at i.
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
        }

        // Stores the length of longest decreasing subsequence that starts at i.
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    ldsLength[i] = Math.max(ldsLength[i], ldsLength[j] + 1);
                }
            }
        }

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (lisLength[i] > 1 && ldsLength[i] > 1) {
                minRemovals = Math.min(
                        minRemovals,
                        N - lisLength[i] - ldsLength[i] + 1
                );
            }
        }

        return minRemovals;
    }
}
