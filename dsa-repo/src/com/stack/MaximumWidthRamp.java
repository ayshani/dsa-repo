package com.stack;

import java.util.Stack;

/*
962. Maximum Width Ramp

A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a
ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.



Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

TC : o(n)
SC: o(n)
 */
public class MaximumWidthRamp {

    public static void main(String[] args) {
        System.out.println(new MaximumWidthRamp().maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || nums[st.peek()]> nums[i]){
                st.push(i);
            }
        }
        int maxWidth =0;

        for(int j= n-1; j>=0;j--){
            while(!st.isEmpty() && nums[st.peek()]<= nums[j]){
                maxWidth = Math.max(maxWidth, j- st.peek());
                st.pop();
            }
        }
        return maxWidth;

    }
}
