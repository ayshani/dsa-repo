package com.dp.knapsack;
/*
Target Sum

Given an array of positive integers arr and a target T, build an expression using these numbers by inserting a
+ or a −
before each integer, and evaluating this expression. Find the total number of different expressions that evaluate to T.

For example, consider an array [1, 1] and a target 0, we can build the following expressions:
+ 1 + 1  = 2
+1 -1 = 0
-1 + 1 =0
-1 -1  =-2
o/p : 2

TC : o(n*T)
SC: o(n*2*sum*1)
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1};
        System.out.println(new TargetSum().findTargetSumWays(arr,0));
    }
    public int findTargetSumWays(int[] arr, int T){

        // Write your code here
        int totalSum =0;
        for(int num : arr){
            totalSum+=num;
        }
        int n = arr.length;
        Integer[][] dp =  new Integer[n+1][2*totalSum+1];
        return util(arr, T, totalSum, 0,0,dp);
    }

    private int util(int[] nums, int T, int totalSum, int i, int sum, Integer[][] dp) {
        if(i==nums.length){
            if(sum==T)
                return 1;
            return 0;
        }

        if(dp[i][sum+totalSum]!=null)
            return dp[i][sum+totalSum];

        int ans = util(nums, T, totalSum, i+1,sum+nums[i],dp) +
                util(nums, T, totalSum, i+1,sum-nums[i],dp);

        return dp[i][sum+totalSum] = ans;
    }


}
