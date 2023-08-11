package com.stack;

import java.util.Arrays;
import java.util.Stack;

/*
503. Next Greater Element II

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next
greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which
means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

TC : o(n)
SC: o(n)
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));
    }
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i%n])
                st.pop();
            if(st.isEmpty())
                res[i%n] = -1;
            else{
                res[i%n] = nums[st.peek()];
            }
            st.push(i%n);
        }

        return res;

    }
}
