package com.greedy;

import java.util.Arrays;

/*
2966. Divide Array Into Arrays With Max Difference

You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an
empty array. And if there are multiple answers, return any of them.



Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.

TC : o(nlogn)
SC: o(1)
 */
public class DivideArrayIntoArraysWithMaxDifference {

    public static void main(String[] args) {
        Arrays.stream(new DivideArrayIntoArraysWithMaxDifference().divideArray(
                new int[]{1,3,4,8,7,9,3,5,1}, 2)).forEach(e -> System.out.println(Arrays.toString(e)));
    }
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] result = new int[n/3][3];
        for(int i=0; i<n;i+=3){
            if(nums[i+2]- nums[i]>k)
                return new int[0][0];
            result[i/3] = new int[]{nums[i],nums[i+1], nums[i+2]};
        }
        return result;
    }
}
