package com.array;

import java.util.ArrayList;
import java.util.List;

/*
3364. Minimum Positive Sum Subarray

You are given an integer array nums and two integers l and r. Your task is to find the minimum sum of a subarray whose size is between l and r (inclusive) and whose sum is greater than 0.

Return the minimum sum of such a subarray. If no such subarray exists, return -1.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [3, -2, 1, 4], l = 2, r = 3

Output: 1

Explanation:

The subarrays of length between l = 2 and r = 3 where the sum is greater than 0 are:

[3, -2] with a sum of 1
[1, 4] with a sum of 5
[3, -2, 1] with a sum of 2
[-2, 1, 4] with a sum of 3
Out of these, the subarray [3, -2] has a sum of 1, which is the smallest positive sum. Hence, the answer is 1.

TC : o(n^2)
SC: o(1)
 */
public class MinimumPositiveSumSubarray {

    public static void main(String[] args) {
        System.out.println(new MinimumPositiveSumSubarray().minimumSumSubarray(
                List.of(3, -2, 1, 4), 2,3
        ));
    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                sum += nums.get(j);
                int len = j-i+1;
                if(len >=l && len <=r && sum >0){
                    ans = Math.min(ans, sum);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}
