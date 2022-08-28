package com.math;
/*
231. Power of Two

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
 */
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(128));
    }
    public boolean isPowerOfTwo(int n) {
        return (n >0 ) && ((n&(n-1))==0);
    }

}
