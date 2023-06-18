package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1679. Max Number of K-Sum Pairs

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.



Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
TC : o(n)
SC: o(n)
 */
public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new MaxNumberOfKSumPairs().maxOperations(nums,5));
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;

        for(int i=0;i<nums.length;i++){
            Integer rest = k-nums[i];
            if(map.containsKey(rest)){
                count++;
                if(map.get(rest)>0){
                    map.put(rest, map.get(rest)-1);
                }else{
                    map.remove(rest);
                }
            } else{
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }
        }
        return count;
    }
}
