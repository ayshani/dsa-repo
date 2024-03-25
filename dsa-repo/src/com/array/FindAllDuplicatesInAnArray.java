package com.array;

import java.util.ArrayList;
import java.util.List;

/*
442. Find All Duplicates in an Array

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer
appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

TC : o(n)
SC: o(n)
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(
                new int[]{4,3,2,7,8,2,3,1}
        ));
    }
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int[] aux = new int[n+1];
        for(int num : nums){
            if(aux[num]<0)
                result.add(num);
            aux[num] = -1;
        }
        return result;
    }
}
