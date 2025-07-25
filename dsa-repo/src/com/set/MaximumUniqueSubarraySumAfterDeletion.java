package com.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
3487. Maximum Unique Subarray Sum After Deletion

You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.



Example 1:

Input: nums = [1,2,3,4,5]

Output: 15

Explanation:

Select the entire array without deleting any element to obtain the maximum sum.

TC : o(n)
SC: o(1)
 */
public class MaximumUniqueSubarraySumAfterDeletion {

    public static void main(String[] args) {
        System.out.println(new MaximumUniqueSubarraySumAfterDeletion().maxSum(new int[]{1,2,3,4,5}));
    }
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num >0){
                set.add(num);
            }
        }

        if(set.isEmpty()){
            return Arrays.stream(nums).max().getAsInt();
        }

        return set.stream().mapToInt(Integer::intValue).sum();
    }
}
