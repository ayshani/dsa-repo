package com.array;
/*
3536. Maximum Product of Two Digits

You are given a positive integer n.

Return the maximum product of any two digits in n.

Note: You may use the same digit twice if it appears more than once in n.



Example 1:

Input: n = 31

Output: 3

Explanation:

The digits of n are [3, 1].
The possible products of any two digits are: 3 * 1 = 3.
The maximum product is 3.

TC : o(n)
SC : o(1)
 */
public class MaximumProductOfTwoDigits {

    public static void main(String[] args) {
        System.out.println(new MaximumProductOfTwoDigits().maxProduct(31));
    }
    public int maxProduct(int n) {
        int first = 0,
                second = 0;
        while (n > 0) {
            int x = n % 10;
            if (x > first) {
                second = first;
                first = x;
            }else if (x > second) {
                second = x;
            }
            n /=10;
        }
        return first * second;
    }
}
