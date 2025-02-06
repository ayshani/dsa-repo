package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1726. Tuple with Same Product

Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.



Example 1:

Input: nums = [2,3,4,6]
Output: 8
Explanation: There are 8 valid tuples:
(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)

TC : o(n^2)
SC: o(n)
 */
public class TupleWithSameProduct {

    public static void main(String[] args) {
        System.out.println(new TupleWithSameProduct().tupleSameProduct( new int[]{2,3,4,6}));
    }
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int totalTuple =0;
        for(int firstIndex =0; firstIndex <n; firstIndex++){
            for(int secIndex =firstIndex +1; secIndex<n; secIndex++){
                freqMap.put(nums[firstIndex] * nums[secIndex], freqMap.getOrDefault(nums[firstIndex] * nums[secIndex], 0)+1 );
            }
        }

        for(int productValue : freqMap.keySet()){
            int freq = freqMap.get(productValue);
            int pairs = (freq-1)*freq/2;
            totalTuple += 8*pairs;
        }
        return totalTuple;
    }
}
