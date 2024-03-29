package com.twopointer;

import java.util.Arrays;

/*
88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

TC: o(n)
SC: o(1)
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0}, nums2 = new int[]{2,5,6};
        new MergeSortedArray().merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j])
            {
                nums1[k--]=nums1[i--];
            }else if(nums2[j]>=nums1[i]){
                nums1[k--]=nums2[j--];
            }
        }

        while(j>=0)
            nums1[k--]=nums2[j--];

    }
}
