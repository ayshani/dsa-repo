package com.stack;

import java.util.Stack;

/*
2789. Largest Element in an Array after Merge Operations
You are given a 0-indexed array nums consisting of positive integers.

You can do the following operation on the array any number of times:

Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. Replace the element
nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
Return the value of the largest element that you can possibly obtain in the final array.



Example 1:

Input: nums = [2,3,7,9,3]
Output: 21
Explanation: We can apply the following operations on the array:
- Choose i = 0. The resulting array will be nums = [5,7,9,3].
- Choose i = 1. The resulting array will be nums = [5,16,3].
- Choose i = 0. The resulting array will be nums = [21,3].
The largest element in the final array is 21. It can be shown that we cannot obtain a larger element.



 */
public class LargestElementInAnArrayAfterMergeOperations {

    public static void main(String[] args) {
        int[] nums = new int[]{34,95,50,12,25,100,21,3,25,16,76,73,93,46,18};
        System.out.println(new LargestElementInAnArrayAfterMergeOperations().maxArrayValue(nums));
    }
    public long maxArrayValue(int[] nums) {
            int n = nums.length;
            if(n==0)
                return 0;
            long sum =nums[n-1], max =nums[0];
            for(int i= n-2; i>=0;i--){
                if(nums[i]<=sum)
                    sum+= nums[i];
                else{
                    sum = nums[i];
                }
                max = Math.max(max, sum);
            }
            return max;
        }

}
