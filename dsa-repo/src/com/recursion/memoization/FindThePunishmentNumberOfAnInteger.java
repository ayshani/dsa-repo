package com.recursion.memoization;
/*
2698. Find the Punishment Number of an Integer
Given a positive integer n, return the punishment number of n.

The punishment number of n is defined as the sum of the squares of all integers i such that:

1 <= i <= n
The decimal representation of i * i can be partitioned into contiguous substrings such that the sum of the integer values of these substrings equals i.


Example 1:

Input: n = 10
Output: 182
Explanation: There are exactly 3 integers i in the range [1, 10] that satisfy the conditions in the statement:
- 1 since 1 * 1 = 1
- 9 since 9 * 9 = 81 and 81 can be partitioned into 8 and 1 with a sum equal to 8 + 1 == 9.
- 10 since 10 * 10 = 100 and 100 can be partitioned into 10 and 0 with a sum equal to 10 + 0 == 10.
Hence, the punishment number of 10 is 1 + 81 + 100 = 182

TC : o(n * 2^{logn))
SC : o(logn)
 */
public class FindThePunishmentNumberOfAnInteger {

    public static void main(String[] args) {
        System.out.println(new FindThePunishmentNumberOfAnInteger().punishmentNumber(10));
    }
    public boolean canPartition(int num, int target) {
        // Invalid partition found
        if (target < 0 || num < target) {
            return false;
        }

        // Valid partition found
        if (num == target) {
            return true;
        }

        // Recursively check all partitions for a valid partition
        return (
                canPartition(num / 10, target - (num % 10)) ||
                        canPartition(num / 100, target - (num % 100)) ||
                        canPartition(num / 1000, target - (num % 1000))
        );
    }

    public int punishmentNumber(int n) {
        int punishmentNum = 0;

        // Iterate through numbers in range [1, n]
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;

            // Check if valid partition can be found and add squared number if so
            if (canPartition(squareNum, currentNum)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }
}
