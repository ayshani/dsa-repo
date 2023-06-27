package com.dp.knapsack;
/*
Subset Sum

Given a set of positive numbers arr and a value total, determine if there exists a subset in the given set whose
sum is equal to total. A subset can be an empty set, or it can either consist of some elements of the set or all
the elements of the set.

Let’s say you are given a set = {1, 2, 3, 7} and a total = 6. The output will be TRUE as the subset = {1, 2, 3}
adds up to make the desired total (1+2+3) = 6.
 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 8, 10};
        System.out.println(new SubsetSum().subsetSum(nums,13));
    }
    public  boolean subsetSum (int [] nums, int total) {
        // Your code will replace the placeholder below
        int n = nums.length;
        Integer[][] dp =  new Integer[n+1][total+1];

        return util(nums, total,n,dp)==1;
    }

    private int util(int[] nums, int total, int n, Integer[][] dp) {
        if(total==0)
            return 1;
        if(n==0)
            return 0;
        if(dp[n][total]!=null)
            return dp[n][total];

        if(nums[n-1]>total){
            dp[n][total] = util(nums,total,n-1,dp);
            return dp[n][total];
        }

        dp[n][total] =  util(nums,total,n-1,dp)  | util(nums,total- nums[n-1],n-1,dp);
        return dp[n][total];
    }


}
