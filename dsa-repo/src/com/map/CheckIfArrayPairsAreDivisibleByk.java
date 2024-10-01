package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
1497. Check If Array Pairs Are Divisible by k

Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.



Example 1:

Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
Example 2:

Input: arr = [1,2,3,4,5,6], k = 7
Output: true
Explanation: Pairs are (1,6),(2,5) and(3,4).

TC: o(n)
SC: o(n)
 */
public class CheckIfArrayPairsAreDivisibleByk {

    public static void main(String[] args) {
        System.out.println(new CheckIfArrayPairsAreDivisibleByk().canArrange(new int[]{1,2,3,4,5,6},7));
    }
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        // Store the count of remainders in a map.
        for (int i : arr) {
            int rem = ((i % k) + k) % k;
            remainderCount.put(rem, remainderCount.getOrDefault(rem, 0) + 1);
        }
        for (int i : arr) {
            int rem = ((i % k) + k) % k;

            // If the remainder for an element is 0, then the count
            // of numbers that give this remainder must be even.
            if (rem == 0) {
                if (remainderCount.get(rem) % 2 == 1) return false;
            }
            // If the remainder rem and k-rem do not have the
            // same count then pairs can not be made.
            else if (
                    !Objects.equals(
                            remainderCount.get(rem),
                            remainderCount.get(k - rem)
                    )
            ) return false;
        }
        return true;
    }
}
