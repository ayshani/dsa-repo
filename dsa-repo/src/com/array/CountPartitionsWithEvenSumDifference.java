package com.array;
/*
3432. Count Partitions with Even Sum Difference

You are given an integer array nums of length n.

A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:

Left subarray contains indices [0, i].
Right subarray contains indices [i + 1, n - 1].
Return the number of partitions where the difference between the sum of the left and right subarrays is even.



Example 1:

Input: nums = [10,10,3,7,6]

Output: 4

Explanation:

The 4 partitions are:

[10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
[10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
[10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
[10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.

TC : o(n)
SC: o(1)

Intuition
Let the sum of the elements in the array nums be sum, and let the sums of the two non-empty subarrays be x and y,
respectively. Clearly, x+y=sum.

If sum is odd, then either x is odd and y is even, or x is even and y is odd, so x−y is odd.

If sum is even, then either both x and y are odd or both are even, so x−y is even.

From this, let n be the number of elements in nums. When sum is even, the number of partitioning schemes with an
even difference is n−1. When sum is odd, the number of such schemes is 0.
 */
public class CountPartitionsWithEvenSumDifference {

    public static void main(String[] args) {
        System.out.println(new CountPartitionsWithEvenSumDifference().countPartitions(new int[]{10,10,3,7,6}));
    }
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }
}
