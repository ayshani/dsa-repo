package com.array;
/*
2091. Removing Minimum and Maximum From Array

You are given a 0-indexed array of distinct integers nums.

There is an element in nums that has the lowest value and an element that has the highest value. We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.

A deletion is defined as either removing an element from the front of the array or removing an element from the back of the array.

Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.



Example 1:

Input: nums = [2,10,7,5,4,1,8,6]
Output: 5
Explanation:
The minimum element in the array is nums[5], which is 1.
The maximum element in the array is nums[1], which is 10.
We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
This results in 2 + 3 = 5 deletions, which is the minimum number possible.

TC : o(n)
SC: o(1)
 */
public class RemovingMinimumAndMaximumFromArray {

    public static void main(String[] args) {
        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(
                new int[]{2,10,7,5,4,1,8,6}
        ));
    }
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        // Find the indices of the minimum and maximum values
        int minidx = 0,
                maxidx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }
            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int l = Math.min(minidx, maxidx); // The smaller value in the most valuable index
        int r = Math.max(minidx, maxidx); // The bigger value in the most valuable index

        // Calculate the minimum number of deletions in three cases
        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
    }
}
