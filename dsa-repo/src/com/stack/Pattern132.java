package com.stack;

import java.util.Stack;

/*
132 Pattern

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and
nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
 */
public class Pattern132 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,4,2};
        System.out.println(new Pattern132().find132pattern(nums));
    }

    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int third = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<third)
                return true;

            if(!st.isEmpty() && st.peek()<nums[i])
                third = st.pop();

            st.push(nums[i]);
        }
        return false;
    }
}
