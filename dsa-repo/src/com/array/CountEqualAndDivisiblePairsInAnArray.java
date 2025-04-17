package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2176. Count Equal and Divisible Pairs in an Array

Given a 0-indexed integer array nums of length n and an integer k,
return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.

Example 1:

Input: nums = [3,1,2,2,2,1,3], k = 2
Output: 4
Explanation:
There are 4 pairs that meet all the requirements:
- nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
- nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
- nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
- nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.

TC : o(n*d) where d is numbers of the indices whose values are same
SC : o(n)
 */
public class CountEqualAndDivisiblePairsInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,2,2,1,3};

        System.out.println(new CountEqualAndDivisiblePairsInAnArray().countPairs(nums,2));
    }
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = map.get(nums[i]);

                for(int index : list){
                    if((i*index)%k==0){
                        count++;
                    }
                }
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return count;
    }
}
