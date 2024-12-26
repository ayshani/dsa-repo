package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
494. Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

TC : o(2^n)
SC: o(n)
 */
public class TargetSum {

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    Map<Map.Entry<Integer,Integer>,Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();

        return dp(nums, target, nums.length-1, 0);
    }

    private int dp(int[] nums, int target, int index, int currentSum){
        Map.Entry<Integer,Integer> entry = Map.entry(index,currentSum);

        if(map.containsKey(entry)){
            return map.get(entry);
        }

        if(index<0 && currentSum == target)
            return 1;

        if(index<0)
            return 0;

        int positiveCount = dp(nums,target, index-1, currentSum + nums[index]);
        int negativeCount = dp(nums,target, index-1, currentSum - nums[index]);

        entry = Map.entry(index,currentSum);
        map.put(entry,positiveCount + negativeCount);

        return positiveCount + negativeCount;
    }
}
