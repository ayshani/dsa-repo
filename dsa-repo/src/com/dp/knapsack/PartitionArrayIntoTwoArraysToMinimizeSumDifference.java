package com.dp.knapsack;
/*
Partition Array Into Two Arrays to Minimize Sum Difference

Suppose you are given an array, nums, containing positive numbers. You need to partition the array into two arrays
such that the absolute difference between their sums is minimized.
Note: Each element of the nums array should be present in one of the partitioned arrays.
Let’s say you have the following array:
[2, 3, 1]
The two partitioned arrays with the minimum difference in their sums are:
[2,1],sum=3
[3],sum=3
So, the minimum difference becomes |3-3|=0

TC : o(n*s)
SC: o(n*s)
 */
public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 4, 7, 2, 9};
        System.out.println(new PartitionArrayIntoTwoArraysToMinimizeSumDifference()
                .minimumPartitionArraySumDifference(nums));
    }
    public int minimumPartitionArraySumDifference(int[] nums) {
        // Write your code here
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total+= num;
        }

        Integer[][] dp = new Integer[n+1][total+1];
        // your code will replace the placeholder return statement below
        return util(nums, 0, 0,0,dp);
    }

    private int util(int[] nums, int i, int sum1, int sum2, Integer[][] dp) {
        if(i==nums.length){
            return Math.abs(sum1-sum2);
        }

        if(dp[i][sum1]!=null)
            return dp[i][sum1];

        dp[i][sum1] = Math.min(util(nums, i+1, sum1+nums[i],sum2,dp),
                util(nums, i+1, sum1,sum2+nums[i],dp))   ;
        return dp[i][sum1];
    }
}
