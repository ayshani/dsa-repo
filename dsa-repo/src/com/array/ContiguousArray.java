package com.array;

import java.util.HashMap;
import java.util.Map;

/*
525. Contiguous Array

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

TC : o(n)
SC: o(n)
 */
public class  ContiguousArray {

    /*
    The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 then we know there are
    even number of -1 and 1 between index i and j. Also put the sum to index mapping to a HashMap to make search
    faster.
    */

    public static void main(String[] args) {
        int[] nums= new int[]{0,1,0,0,1,1,1,0,1,0};
        System.out.println(new ContiguousArray().findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int sum =0, max =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i]==1?1:-1;
            if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum,i);
        }
        return max;
    }
}
