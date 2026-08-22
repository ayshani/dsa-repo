package com.math;
/*
3622. Check Divisibility by Digit Sum and Product

You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:

The digit sum of n (the sum of its digits).

The digit product of n (the product of its digits).

Return true if n is divisible by this sum; otherwise, return false.



Example 1:

Input: n = 99

Output: true

Explanation:

Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of its digits (total 99), the output is true.

TC  : o(logn)
SC: o(1)
 */
public class CheckDivisibilityByDigitSumAndProduct {

    public static void main(String[] args) {
        System.out.println(new CheckDivisibilityByDigitSumAndProduct().checkDivisibility(99));
    }
    public boolean checkDivisibility(int n) {
        int digitSum =0, digitProduct =1, original =n;

        while(n>0){
            int digit = n%10;
            n/=10;
            digitSum += digit;
            digitProduct *= digit;
        }

        return original % (digitSum+ digitProduct) == 0;
    }
}
