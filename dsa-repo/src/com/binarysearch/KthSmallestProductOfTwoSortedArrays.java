package com.binarysearch;
/*
2040. Kth Smallest Product of Two Sorted Arrays

Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.


Example 1:

Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The 2 smallest products are:
- nums1[0] * nums2[0] = 2 * 3 = 6
- nums1[0] * nums2[1] = 2 * 4 = 8
The 2nd smallest product is 8.

TC : o(nlogm)
SC: o(m+n)
 */
public class KthSmallestProductOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(new KthSmallestProductOfTwoSortedArrays().kthSmallestProduct(
                new int[]{2,5}, new int[]{3,4}, 2
        ));
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countProducts(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countProducts(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int num1 : nums1) {
            if (num1 == 0) {
                if (target >= 0) count += nums2.length;
                continue;
            }

            int low = 0, high = nums2.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
                long product = (long) num1 * nums2[mid];
                if (product <= target) {
                    if (num1 > 0) low = mid + 1;
                    else high = mid;
                } else {
                    if (num1 > 0) high = mid;
                    else low = mid + 1;
                }
            }

            count += (num1 > 0) ? low : nums2.length - low;
        }
        return count;
    }
}
