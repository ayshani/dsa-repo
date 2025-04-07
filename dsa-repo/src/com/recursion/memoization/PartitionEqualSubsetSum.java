package com.recursion.memoization;
/*
416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

TC : o(n^2)
SC : o(n^2)
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1,5,11,5}));
    }
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        for(int num : nums){
            totalSum+=num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if(totalSum%2!=0)
            return false;

        int subsetSum = totalSum/2;
        int n = nums.length;

        Boolean[][] memo = new Boolean[n+1][subsetSum+1];
        return dfs(nums, n-1, subsetSum,memo);
    }

    private boolean dfs(int[] nums, int n, int subsetSum, Boolean[][] memo){
        // Base Cases
        if(subsetSum==0)
            return true;

        if(n==0 || subsetSum<0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if(memo[n][subsetSum] != null)
            return memo[n][subsetSum];

        boolean result = dfs(nums, n-1, subsetSum - nums[n-1], memo) ||
                dfs(nums, n-1, subsetSum,memo);

        return memo[n][subsetSum] = result;
    }
}
