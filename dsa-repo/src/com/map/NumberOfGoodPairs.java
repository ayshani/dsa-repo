package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1512. Number of Good Pairs

Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

TC : o(n)
SC: o(n)
 */
public class NumberOfGoodPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,1,3};
        System.out.println(new NumberOfGoodPairs().numIdenticalPairs(nums));
    }
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        int count =0;
        for(int val : map.values()){
            if(val>1){
                count += (val*(val-1))/2;
            }
        }
        return count;
    }
}
