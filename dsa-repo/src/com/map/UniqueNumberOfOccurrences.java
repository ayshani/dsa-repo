package com.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique,
or false otherwise.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

TC : o(n)
SC : o(n)
 */
public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(arr));
    }
    public boolean uniqueOccurrences(int[] arr) {
        // Store the frequency of elements in the unordered map.
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // Store the frequency count of elements in the unordered set.
        Set<Integer> set = new HashSet<>(map.values());

        // If the set size is equal to the map size,
        // It implies frequency counts are unique.
        return map.size()== set.size();

    }
}
