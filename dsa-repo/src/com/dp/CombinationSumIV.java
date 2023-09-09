package com.dp;

import java.util.Arrays;

/*
377. Combination Sum IV

Given an array of distinct integers nums and a target integer target,
return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.



Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.


Logic
------
Take a dp[] of target+1 size.
start from 0t index of nums[] and call one helper() with target-nums[i].
So, when target becomes 0, that means we got one combination. we return 1 and add the to a count variable.

TC : o(mn)
Sc : o(n)
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        System.out.println(new CombinationSumIV().combinationSum4(nums,target));
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        int ans = solve(nums,target,dp);
        return ans;
    }

    private int solve(int[] nums, int target,int[] dp){
        if(target==0)
        {
            return 1;
        }
        if(dp[target]!=-1)
            return dp[target];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                count+= solve(nums,target-nums[i],dp);
            }
        }
        dp[target]=count;

        return dp[target];

    }
}
