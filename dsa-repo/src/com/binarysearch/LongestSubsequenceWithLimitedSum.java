package com.binarysearch;

import java.util.Arrays;

/*
2389. Longest Subsequence With Limited Sum

You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take
from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no elements without changing
the order of the remaining elements.



Example 1:

Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such
  a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such
  a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such
  a subsequence, so answer[2] = 4.


TC : o(nlogn + mlogn)
SC : o(logn )
 */
public class LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,2,1}, q = new int[]{3,10,21};

        int[] res = new LongestSubsequenceWithLimitedSum().answerQueries(nums,q);

        Arrays.stream(res).forEach(value -> System.out.print(value+" "));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }

        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int index = binarySearch(nums,  queries[i]);
            ans[i] = index;
        }

        return ans;
    }

    private int binarySearch(int[] nums, int target){
        int l =0,r = nums.length-1;
        while(l<r){
            int mid  = (l+r)/2;

            if(nums[mid]==target)
                return mid+1;
            else if(nums[mid]<target)
                l= mid+1;
            else
                r = mid-1;
        }

        return nums[l] > target? l : l+1;
    }
}
