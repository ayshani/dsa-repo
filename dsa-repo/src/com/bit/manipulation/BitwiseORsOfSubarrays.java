package com.bit.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
898. Bitwise ORs of Subarrays

Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.

TC : o(nlogw)
SC: o(nlogw)
 */
public class BitwiseORsOfSubarrays {

    public static void main(String[] args) {
        System.out.println(new BitwiseORsOfSubarrays().subarrayBitwiseORs(new int[]{0,2,3,4}));
    }
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);

        for (int x: arr) {
            Set<Integer> cur2 = new HashSet();
            for (int y: cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
