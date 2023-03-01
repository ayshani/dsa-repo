package com.sort;

import java.util.Map;
import java.util.TreeMap;

/*
954. Array of Doubled Pairs

Given an integer array of even length arr, return true if it is possible to reorder arr
such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.



Example 1:

Input: arr = [3,1,3,6]
Output: false

TC : o(n)
SC: o(n)
 */
public class ArrayOfDoubledPairs {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,6};
        System.out.println(new ArrayOfDoubledPairs().canReorderDoubled(nums));

    }
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> map = new TreeMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)==0)
                continue;

            if(key<0 && key%2!=0)
                return false;

            int target = key<0 ? key/2 : key*2;

            if(map.get(key)> map.getOrDefault(target,0))
                return false;

            map.put(target , map.get(target)-map.get(key));
        }

        return true;
    }
}
