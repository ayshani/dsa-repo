package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3069. Distribute Elements Into Two Arrays I

You are given a 1-indexed array of distinct integers nums of length n.

You need to distribute all the elements of nums between two arrays arr1 and arr2 using n operations. In the first
operation, append nums[1] to arr1. In the second operation, append nums[2] to arr2. Afterwards, in the ith operation:

If the last element of arr1 is greater than the last element of arr2, append nums[i] to arr1. Otherwise, append
nums[i] to arr2.
The array result is formed by concatenating the arrays arr1 and arr2. For example, if arr1 == [1,2,3] and
arr2 == [4,5,6], then result = [1,2,3,4,5,6].

Return the array result.



Example 1:

Input: nums = [2,1,3]
Output: [2,3,1]
Explanation: After the first 2 operations, arr1 = [2] and arr2 = [1].
In the 3rd operation, as the last element of arr1 is greater than the last element of arr2 (2 > 1),
append nums[3] to arr1.
After 3 operations, arr1 = [2,3] and arr2 = [1].
Hence, the array result formed by concatenation is [2,3,1].

TC : o(n)
SC: o(n)
 */
public class DistributeElementsIntoTwoArraysI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistributeElementsIntoTwoArraysI().resultArray(new int[]{2, 1, 3})));
    }
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] res = new int[n];
        int idx = 0;
        for (int x : arr1) {
            res[idx++] = x;
        }
        for (int x : arr2) {
            res[idx++] = x;
        }
        return res;
    }
}
