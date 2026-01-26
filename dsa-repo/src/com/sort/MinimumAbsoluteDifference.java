package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

1200. Minimum Absolute Difference

Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr


Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

TC: o(nlogn)
SC: o(logn)
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        System.out.println(new MinimumAbsoluteDifference().minimumAbsDifference(
                new int[]{4,2,1,3}
        ));
    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i ++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i ++){
            if (arr[i + 1] - arr[i] == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
