package com.array;
/*
 * 1508. Range Sum of Sorted Subarray Sums
 *
 * You are given the array nums consisting of n positive integers.
 * You computed the sum of all non-empty continuous subarrays from
 * the array and then sorted them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1),
inclusive, in the new array. Since the answer can be a huge number return it modulo 109 + 7.

Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4.
After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.

 */

import java.util.Arrays;

public class RangeSumOfSortedSubarraySums {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums= new int[] {1,2,3,4};
        int n = 4, left = 1, right = 5;
        RangeSumOfSortedSubarraySums obj = new RangeSumOfSortedSubarraySums();
        System.out.println(obj.rangeSum(nums, n, left, right));
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int index =0;
        int[] aux = new int[n*(n+1)/2];
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                aux[index++] = sum;
            }
        }
        Arrays.sort(aux);
        int sum =0;
        for(int i=left-1;i<right;i++){
            sum = (sum+aux[i])%1000000007;
        }
        return sum;
    }

}
