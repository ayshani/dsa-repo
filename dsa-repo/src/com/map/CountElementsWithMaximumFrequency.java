package com.map;
/*
3005. Count Elements With Maximum Frequency

You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.



Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.

TC : o(n)
SC: o(n)

 */

import java.util.Map;
import java.util.HashMap;

public class CountElementsWithMaximumFrequency {

    public static void main(String[] args) {
        System.out.println(new CountElementsWithMaximumFrequency().maxFrequencyElements(new int[]{1,2,2,3,4,1}));
    }
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int max =0;
        int count =0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()> max){
                max = entry.getValue();
                count = max;
            } else if(entry.getValue()== max){
                count += entry.getValue();
            }
        }
        return count;
    }
}
