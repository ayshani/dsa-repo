package com.array;
/*
3345. Smallest Divisible Digit Product I

You are given two integers n and t. Return the smallest number greater than or equal to n such that the product
of its digits is divisible by t.



Example 1:

Input: n = 10, t = 2

Output: 10

Explanation:

The digit product of 10 is 0, which is divisible by 2, making it the smallest number greater than or equal to 10
that satisfies the condition.

Time complexity: O(10logn).

Space complexity: O(1).

 */
public class SmallestDivisibleDigitProductI {

    public static void main(String[] args) {
        System.out.println(new SmallestDivisibleDigitProductI().smallestNumber(10,2));
    }
    public int smallestNumber(int n, int t) {
        while (!check(n, t)) {
            n++;
        }
        return n;
    }

    private boolean check(int num, int t) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
            if (product == 0) {
                break;
            }
        }
        return product % t == 0;
    }
}
