package com.dp;
/*
1390. Four Divisors

Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.



Example 1:

Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.


 */
public class FourDivisors {

    public static void main(String[] args) {
        System.out.println(new FourDivisors().sumFourDivisors(new int[]{21,4,7}));
    }
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int last_d = 0;
            for (int d = 2; d * d <= n; ++d) {
                if (n % d == 0) {
                    if (last_d == 0)
                        last_d = d;
                    else {
                        last_d = 0;
                        break;
                    }
                }
            }
            if (last_d > 0 && last_d != n / last_d) {
                sum += 1 + n + last_d + n / last_d;
            }
        }
        return sum;
    }
}
