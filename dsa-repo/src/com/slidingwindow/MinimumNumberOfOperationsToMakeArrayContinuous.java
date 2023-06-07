package com.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
2009. Minimum Number of Operations to Make Array Continuous

You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

nums is considered continuous if both of the following conditions are fulfilled:

All elements in nums are unique.
The difference between the maximum element and the minimum element in nums equals nums.length - 1.
For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

Return the minimum number of operations to make nums continuous.



Example 1:

Input: nums = [4,2,5,3]
Output: 0
Explanation: nums is already continuous.

TC: o(n)
SC: o(n)
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,3};
        System.out.println(new MinimumNumberOfOperationsToMakeArrayContinuous().minOperations(nums));
    }
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxWindowSize=0;
        Deque<Integer> dq = new LinkedList<>();

        for(int i=0;i<n;i++){
            while(dq.size()>0 && nums[i]-dq.peekFirst()>=n)
                dq.poll();
            if(dq.size()==0 || dq.peekLast()!=nums[i])
                dq.offer(nums[i]);
            maxWindowSize = Math.max(maxWindowSize,dq.size());
        }

        return n - maxWindowSize;
    }
}
