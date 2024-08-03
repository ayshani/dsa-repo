package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1460. Make Two Arrays Equal by Reversing Subarrays

You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty
subarray of arr and reverse it. You are allowed to make any number of steps.

Return true if you can make arr equal to target or false otherwise.

Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
2- Reverse subarray [4,2], arr becomes [1,2,4,3]
3- Reverse subarray [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.

TC : o(n)
SC: o(n)

 */
public class MakeTwoArraysEqualByReversingSubarrays {

    public static void main(String[] args) {
        System.out.println(new MakeTwoArraysEqualByReversingSubarrays().canBeEqual(
                new int[]{1,2,3,4}, new int[]{2,4,1,3}
        ));
    }
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : arr){
            count.put(num, count.getOrDefault(num,0)+1);
        }

        for(int num : target){
            if(!count.containsKey(num)){
                return false;
            }
            count.put(num, count.get(num)-1);
            if(count.get(num)==0){
                count.remove(num);
            }
        }
        return count.size()==0;
    }
}
