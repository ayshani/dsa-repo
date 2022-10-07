package com.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
2006. Count Number of Pairs With Absolute Difference K

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such
that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.


Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]

TC : o(n)
SC : o(n)
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,4};
        System.out.println(new CountNumberOfPairsWithAbsoluteDifferenceK().countKDifference(nums,2));
    }
    public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res =0;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                res+= map.get(nums[i]-k);
            }
            if(map.containsKey(nums[i]+k)){
                res+= map.get(nums[i]+k);
            }

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        return res;
    }
}
