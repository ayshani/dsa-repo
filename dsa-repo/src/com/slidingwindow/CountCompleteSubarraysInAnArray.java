package com.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
2799. Count Complete Subarrays in an Array

You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.



Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].


TC : o(n)
SC: o(n)
 */
public class CountCompleteSubarraysInAnArray {

    public static void main(String[] args) {
        System.out.println(new CountCompleteSubarraysInAnArray().countCompleteSubarrays(
                new int[]{1,3,1,2,2}
        ));
    }
    public int countCompleteSubarrays(int[] nums) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int right = 0;
        int distinct = new HashSet<>(
                Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))
        ).size();

        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left - 1];
                cnt.put(remove, cnt.get(remove) - 1);
                if (cnt.get(remove) == 0) {
                    cnt.remove(remove);
                }
            }
            while (right < n && cnt.size() < distinct) {
                int add = nums[right];
                cnt.put(add, cnt.getOrDefault(add, 0) + 1);
                right++;
            }
            if (cnt.size() == distinct) {
                res += (n - right + 1);
            }
        }
        return res;
    }
}
