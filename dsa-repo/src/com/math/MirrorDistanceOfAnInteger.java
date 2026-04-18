package com.math;
/*
3783. Mirror Distance of an Integer

You are given an integer n.

Define its mirror distance as: abs(n - reverse(n))where reverse(n) is the integer formed by reversing the digits of n.

Return an integer denoting the mirror distance of n.

abs(x) denotes the absolute value of x.



Example 1:

Input: n = 25

Output: 27

Explanation:

reverse(25) = 52.
Thus, the answer is abs(25 - 52) = 27.

TC : o(logn)
SC: o(1)
 */
public class MirrorDistanceOfAnInteger {

    public static void main(String[] args) {
        System.out.println(new MirrorDistanceOfAnInteger().mirrorDistance(25));
    }
    public int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + (n % 10);
            n /= 10;
        }
        return res;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}
