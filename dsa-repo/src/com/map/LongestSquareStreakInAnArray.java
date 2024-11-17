package com.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2501. Longest Square Streak in an Array

You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing
the order of the remaining elements.



Example 1:

Input: nums = [4,3,6,16,8,2]
Output: 3
Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
- 4 = 2 * 2.
- 16 = 4 * 4.
Therefore, [4,16,2] is a square streak.
It can be shown that every subsequence of length 4 is not a square streak.

 */
public class LongestSquareStreakInAnArray {

    public static void main(String[] args) {
        System.out.println(new LongestSquareStreakInAnArray().longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }
    public int longestSquareStreak(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for(int number : nums){
            int root = (int)Math.sqrt(number);
            if(root*root == number && map.containsKey(root)){
                map.put(number, map.get(root)+1);
            } else{
                map.put(number,1);
            }
        }

        int longestStreak = 0;
        for(int length : map.values()){
            longestStreak = Math.max(longestStreak, length);
        }

        return longestStreak == 1 ? -1 : longestStreak;
    }
}