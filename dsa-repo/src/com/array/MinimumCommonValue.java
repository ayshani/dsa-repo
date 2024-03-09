package com.array;
/*
2540. Minimum Common Value

Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to
both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that
integer.



Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.

TC : o(n)
SC: o(1)
 */
public class MinimumCommonValue {

    public static void main(String[] args) {
        System.out.println(new MinimumCommonValue().getCommon(new int[]{1,2,3}, new int[]{2,4}));
    }
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0, j =0;
        int m = nums1.length, n = nums2.length;
        int min = Integer.MAX_VALUE;
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            } else if(nums1[i]<nums2[j]){
                i++;
            } else{
                j++;
            }
        }
        return -1;

    }
}
