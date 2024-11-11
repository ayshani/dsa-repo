package com.array;
/*
2601. Prime Subtraction Operation

You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.



Example 1:

Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.

TC : o(n)
SC:o(n)
 */
public class PrimeSubtractionOperation {

    public static void main(String[] args) {
        System.out.println(new PrimeSubtractionOperation().primeSubOperation(new int[]{4,9,6,10}));
    }
    public boolean primeSubOperation(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        int[] previousPrime = new int[maxElement + 1];
        for (int i = 2; i <= maxElement; i++) {
            if (isPrime(i)) {
                previousPrime[i] = i;
            } else {
                previousPrime[i] = previousPrime[i - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int bound;
            // In case of first index, we need to find the largest prime less
            // than nums[0].
            if (i == 0) {
                bound = nums[0];
            } else {
                // Otherwise, we need to find the largest prime, that makes the
                // current element closest to the previous element.
                bound = nums[i] - nums[i - 1];
            }
            // If the bound is less than or equal to 0, then the array cannot be
            // made strictly increasing.
            if (bound <= 0) {
                return false;
            }

            // Find the largest prime less than bound.
            int largestPrime = previousPrime[bound - 1];

            // Subtract this value from nums[i].
            nums[i] -= largestPrime;
        }
        return true;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
