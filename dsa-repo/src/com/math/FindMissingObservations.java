package com.math;

import java.util.Arrays;

/*
2028. Find Missing Observations

You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went
missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of
the n + m rolls.

You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also
given the two integers mean and n.

Return an array of length n containing the missing observations such that the average value of the n + m rolls is
exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty
array.

The average value of a set of k numbers is the sum of the numbers divided by k.

Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.

Example 1:

Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.

TC : o(max(m,n))
SC: o(1)
 */
public class FindMissingObservations {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindMissingObservations().missingRolls(
                new int[]{3,2,4,3}, 4, 2
        )));
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum = sum + roll;
        }

        // Find the remaining sum.
        int remainingSum = mean * (n + rolls.length) - sum;

        // Check if sum is valid or not.
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }

        int distributeMean = remainingSum / n;
        int mod = remainingSum % n;

        // Distribute the remaining mod elements in nElements array.
        int[] nElements = new int[n];
        Arrays.fill(nElements, distributeMean);
        for (int i = 0; i < mod; i++) {
            nElements[i]++;
        }
        return nElements;
    }
}
