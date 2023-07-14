package com.dp;

import java.util.HashMap;
import java.util.Map;

/*
1218. Longest Arithmetic Subsequence of Given Difference

Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is
an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order
of the remaining elements.

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].


Explanation
------------
The key idea of the DP approach is to use a hash map dp to store the maximum length of an arithmetic subsequence
that ends with each element in arr. We initialize dp as empty. Then, for each element arr[i], we check if
arr[i] - difference is already present in dp.

If it is, let's say dp[arr[i] - difference] = before_a. It means there exists an arithmetic subsequence of
length before_a that ends with arr[i] - difference. Since we can append arr[i] to this sequence, we update
dp[arr[i]] to be dp[arr[i] - difference] + 1.

Otherwise, we simply set dp[arr[i]] = 1, as an element on its own is technically an arithmetic subsequence.

TC : o(n)
SC: o(n)
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(new LongestArithmeticSubsequenceOfGivenDifference().longestSubsequence(arr,1));
    }
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length, max =0;
        Map<Integer,Integer> dp = new HashMap<>();
        for(int num : arr){
            int countBeforeNum = dp.getOrDefault(num-difference, 0);
            dp.put(num, countBeforeNum+1);
            max = Math.max(max, dp.get(num));
        }
        return max;
    }

}
