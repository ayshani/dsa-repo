package com.greedy;
/*
2366. Minimum Replacements to Sort the Array

You are given a 0-indexed integer array nums. In one operation you can replace any element of the array with any
two elements that sum to it.

For example, consider nums = [5,6,7]. In one operation, we can replace nums[1] with 2 and 4 and convert nums
to [5,2,4,7].
Return the minimum number of operations to make an array that is sorted in non-decreasing order.



Example 1:

Input: nums = [3,9,3]
Output: 2
Explanation: Here are the steps to sort the array in non-decreasing order:
- From [3,9,3], replace the 9 with 3 and 6 so the array becomes [3,3,6,3]
- From [3,3,6,3], replace the 6 with 3 and 3 so the array becomes [3,3,3,3,3]
There are 2 steps to sort the array in non-decreasing order. Therefore, we return 2.

TC : o(n)
SC: o(1)
 */
public class MinimumReplacementsToSortTheArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,9,3};
        System.out.println(new MinimumReplacementsToSortTheArray().minimumReplacement(nums));
    }
    public long minimumReplacement(int[] nums) {
        long ans =0;
        int n = nums.length;
        // Start from the second last element, as the last one is always sorted.
        for(int i=n-2;i>=0;i--){
            // No need to break if they are already in order.
            if(nums[i]<=nums[i+1]){
                continue;
            }

            // Count how many elements are made from breaking nums[i].
            long numElements = (long)(nums[i] + nums[i+1] -1) / (long)nums[i+1];
            // It requires numElements - 1 replacement operations.
            ans += numElements-1;
            // Maximize nums[i] after replacement.
            nums[i] = nums[i]/ (int)numElements;
        }
        return ans;
    }
}
