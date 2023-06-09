package com.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
Count of pairs whose bitwise AND is a power of
https://www.geeksforgeeks.org/count-of-pairs-whose-bitwise-and-is-a-power-of-2/

Given an array arr[] of N positive integers. The task is to find the number of pairs whose Bitwise AND value
is a power of 2.
Examples:


Input: arr[] = {2, 1, 3, 4}
Output: 2
Explanation:
There are 2 pairs (2, 3) and (1, 3) in this array whose Bitwise AND values are:
1. (2 & 3) = 1 = (20)
2. (1 & 3) = 1 = (20).
Input: arr[] = {6, 4, 2, 3}
Output: 4
Explanation:
There are 4 pairs (6, 4), (6, 2), (6, 3), (2, 3) whose Bitwise and is power of 2.

Exp:
we can use a hash map to store the frequency of each integer in the array. Then, we can iterate through each
integer i in the array and check if it is present in the hash map. If it is present, we can iterate through
each integer j in the array from i to the maximum value in the array and check if it is present in the hash map.
If it is present, we can find their bitwise AND using the “&” operator and check if the result has only one set bit.
If it does, we can count this pair.

TC : o(n^2)
SC: o(n)
 */
public class CountOfPairsWhoseBitwiseANDIsAPowerOf2 {
    public static long countPairs(int[] arr, int n)
    {

        long ans = 0, mx = 0;
        // create a hash map to store the frequency of each
        // integer in the array
        Map<Integer, Integer> mp = new HashMap<>();
        for (int ai : arr) {
            // update the frequency of each integer in the
            // hash map
            mp.put(ai, mp.getOrDefault(ai, 0) + 1);
            // find the maximum value in the array
            mx = Math.max(mx, ai);
        }
        // iterate through each integer i from 0 to mx
        for (int i = 0; i <= mx; ++i) {
            // if i is not present in the hash map, skip to
            // the next integer
            if (!mp.containsKey(i))
                continue;
            // iterate through each integer j from i to mx
            for (int j = i; j <= mx; ++j) {
                // if j is not present in the hash map, skip
                // to the next integer
                if (!mp.containsKey(j))
                    continue;
                // check if the bitwise AND of i and j has
                // only one set bit
                if (Long.bitCount(i & j) == 1) {
                    // if i is equal to j, add the product
                    // of nCr(mp.get(i), 2) to the answer
                    if (i == j)
                        ans += ((long)mp.get(i)
                                * (mp.get(i) - 1))
                                / 2;
                        // if i is not equal to j, add the
                        // product of mp.get(i) and mp.get(j) to
                        // the answer
                    else
                        ans += ((long)mp.get(i))
                                * mp.get(j);
                }
            }
        }
        // return the answer
        return ans;
    }
    // Driver Code
    public static void main(String[] args)
    {

        // Given array arr[]
        int arr[] = new int[] { 6, 4, 2, 3 };

        int n = arr.length;

        // Function call
        System.out.print(countPairs(arr, n));
    }


}
