package com.map;

import java.util.HashMap;
import java.util.Map;

/*
1346. Check If N and Its Double Exist

Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]


Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

TC : o(n)
SC: o(n)
 */
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{10,2,5,3}));
    }
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            // Count occurrences of each number
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            // Check for double
            if (num != 0 && map.containsKey(2 * num)) {
                return true;
            }
            // Handle zero case (ensure there are at least two zeros)
            if (num == 0 && map.get(num) > 1) {
                return true;
            }
        }
        return false;
    }
}
