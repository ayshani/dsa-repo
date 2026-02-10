package com.map;

import java.util.HashMap;
import java.util.Map;

/*
3719. Longest Balanced Subarray I

You are given an integer array nums.

A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.

Return the length of the longest balanced subarray.



Example 1:

Input: nums = [2,5,4,3]

Output: 4

Explanation:

The longest balanced subarray is [2, 5, 4, 3].
It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [5, 3]. Thus, the answer is 4.

TC : o(n^2)
SC: o(n)
 */
public class LongestBalancedSubarrayI {

    public static void main(String[] args) {
        System.out.println(new LongestBalancedSubarrayI().longestBalanced(new int[]{2,5,4,3}));
    }
    public int longestBalanced(int[] nums) {
        int len = 0;
        for(int i=0;i<nums.length;i++){
            Map<Integer, Integer> even = new HashMap<>(), odd = new HashMap<>();

            for(int j=i;j<nums.length;j++){
                Map<Integer, Integer> map = (nums[j]&1) == 1 ? odd : even;
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

                if(odd.size()== even.size()){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
}
