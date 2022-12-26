package com.array;
/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

TC : o(n)
SC : o(1)
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new JumpGame().canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int reach =0;
        for(int i=0;i<n;i++){
            if(reach<i)
                return false;
            reach=Math.max(reach,i+nums[i]);
        }

        return true;
    }
}
