package com.map;

import java.util.HashMap;
import java.util.Map;

/*
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices
i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

TC : o(n)
SC : o(n)
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,1,2,3};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums,2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && (i- map.get(nums[i]))<=k){
                return true;
            }
            map.put(nums[i],i);
        }

        return false;
    }

}
