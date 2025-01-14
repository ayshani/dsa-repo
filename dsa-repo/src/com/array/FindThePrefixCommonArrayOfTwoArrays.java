package com.array;

import java.util.Arrays;

/*
2657. Find the Prefix Common Array of Two Arrays

You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.



Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

TC : o(n)
SC: o(n)
 */
public class FindThePrefixCommonArrayOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindThePrefixCommonArrayOfTwoArrays().findThePrefixCommonArray(
                new int[]{1,3,2,4}, new int[]{3,1,2,4}
        )));
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommonArray = new int[n];
        int[] frequency = new int[n + 1];
        int commonCount = 0;

        // Iterate through the elements of both arrays
        for (int currentIndex = 0; currentIndex < n; ++currentIndex) {
            // Increment frequency of current elements in A and B
            // Check if the element in A has appeared before (common in prefix)
            frequency[A[currentIndex]] += 1;
            if (frequency[A[currentIndex]] == 2) ++commonCount;

            // Check if the element in B has appeared before (common in prefix)
            frequency[B[currentIndex]] += 1;
            if (frequency[B[currentIndex]] == 2) ++commonCount;

            // Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }
        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }
}
