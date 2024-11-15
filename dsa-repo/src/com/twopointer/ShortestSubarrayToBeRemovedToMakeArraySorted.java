package com.twopointer;
/*
1574. Shortest Subarray to be Removed to Make Array Sorted

Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.

Return the length of the shortest subarray to remove.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: arr = [1,2,3,10,4,2,3,5]
Output: 3
Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
Another correct solution is to remove the subarray [3,10,4].

TC:o(n)
SC: o(1)
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public static void main(String[] args) {
        System.out.println(new ShortestSubarrayToBeRemovedToMakeArraySorted().findLengthOfShortestSubarray(
                new  int[]{1,2,3,10,4,2,3,5}
        ));
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int ans = right;
        int left = 0;
        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            // find next valid number after arr[left]
            while (right < arr.length && arr[left] > arr[right]) {
                right++;
            }
            // save length of removed subarray
            ans = Math.min(ans, right - left - 1);
            left++;
        }
        return ans;
    }
}
