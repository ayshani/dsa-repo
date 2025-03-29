package com.heap.max;

import java.util.*;

/*
2818. Apply Operations to Maximize Score

You are given an array nums of n positive integers and an integer k.

Initially, you start with a score of 1. You have to maximize your score by applying the following operation at most k times:

Choose any non-empty subarray nums[l, ..., r] that you haven't chosen previously.
Choose an element x of nums[l, ..., r] with the highest prime score. If multiple such elements exist, choose the one with the smallest index.
Multiply your score by x.
Here, nums[l, ..., r] denotes the subarray of nums starting at index l and ending at the index r, both ends being inclusive.

The prime score of an integer x is equal to the number of distinct prime factors of x. For example, the prime score of 300 is 3 since 300 = 2 * 2 * 3 * 5 * 5.

Return the maximum possible score after applying at most k operations.

Since the answer may be large, return it modulo 109 + 7.



Example 1:

Input: nums = [8,3,9,3,8], k = 2
Output: 81
Explanation: To get a score of 81, we can apply the following operations:
- Choose subarray nums[2, ..., 2]. nums[2] is the only element in this subarray. Hence, we multiply the score by nums[2]. The score becomes 1 * 9 = 9.
- Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 1, but nums[2] has the smaller index. Hence, we multiply the score by nums[2]. The score becomes 9 * 9 = 81.
It can be proven that 81 is the highest score one can obtain.

TC : o(n*(root(m)+logn))
SC: o(n)
 */
public class ApplyOperationsToMaximizeScore {

    public static void main(String[] args) {
        System.out.println(new ApplyOperationsToMaximizeScore().maximumScore(
                List.of(8,3,9,3,8), 2
        ));
    }
    final int MOD = 1000000007;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer> primeScores = new ArrayList<>(Collections.nCopies(n, 0));

        // Calculate the prime score for each number in nums
        for (int index = 0; index < n; index++) {
            int num = nums.get(index);

            // Check for prime factors from 2 to sqrt(n)
            for (int factor = 2; factor <= Math.sqrt(num); factor++) {
                if (num % factor == 0) {
                    // Increment prime score for each prime factor
                    primeScores.set(index, primeScores.get(index) + 1);

                    // Remove all occurrences of the prime factor from num
                    while (num % factor == 0) num /= factor;
                }
            }

            // If num is still greater than or equal to 2, it's a prime factor
            if (num >= 2) primeScores.set(index, primeScores.get(index) + 1);
        }

        // Initialize next and previous dominant index arrays
        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);

        // Stack to store indices for monotonic decreasing prime score
        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();

        // Calculate the next and previous dominant indices for each number
        for (int index = 0; index < n; index++) {
            // While the stack is not empty and the current prime score is greater than the stack's top
            while (
                    !decreasingPrimeScoreStack.isEmpty() &&
                            primeScores.get(decreasingPrimeScoreStack.peek()) <
                                    primeScores.get(index)
            ) {
                int topIndex = decreasingPrimeScoreStack.pop();

                // Set the next dominant element for the popped index
                nextDominant[topIndex] = index;
            }

            // If the stack is not empty, set the previous dominant element for the current index
            if (!decreasingPrimeScoreStack.isEmpty()) prevDominant[index] =
                    decreasingPrimeScoreStack.peek();

            // Push the current index onto the stack
            decreasingPrimeScoreStack.push(index);
        }

        // Calculate the number of subarrays in which each element is dominant
        long[] numOfSubarrays = new long[n];
        for (int index = 0; index < n; index++) {
            numOfSubarrays[index] =
                    ((long) nextDominant[index] - index) *
                            (index - prevDominant[index]);
        }

        // Priority queue to process elements in decreasing order of their value
        PriorityQueue<int[]> processingQueue = new PriorityQueue<>((a, b) -> {
            if (b[0] == a[0]) {
                return Integer.compare(a[1], b[1]); // break tie based on the index (ascending order)
            }
            return Integer.compare(b[0], a[0]); // descending order for the value
        });

        // Push each number and its index onto the priority queue
        for (int index = 0; index < n; index++) {
            processingQueue.offer(new int[] { nums.get(index), index });
        }

        long score = 1;

        // Process elements while there are operations left
        while (k > 0) {
            // Get the element with the maximum value from the queue
            int[] top = processingQueue.poll();
            int num = top[0];
            int index = top[1];

            // Calculate the number of operations to apply on the current element
            long operations = Math.min((long) k, numOfSubarrays[index]);

            // Update the score by raising the element to the power of operations
            score = (score * power(num, operations)) % MOD;

            // Reduce the remaining operations count
            k -= operations;
        }

        return (int) score;
    }

    // Helper function to compute the power of a number modulo MOD
    private long power(long base, long exponent) {
        long res = 1;

        // Calculate the exponentiation using binary exponentiation
        while (exponent > 0) {
            // If the exponent is odd, multiply the result by the base
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }

            // Square the base and halve the exponent
            base = (base * base) % MOD;
            exponent /= 2;
        }

        return res;
    }
}
