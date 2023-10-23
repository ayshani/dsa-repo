package com.math;
/*
342. Power of Four

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:

Input: n = 16
Output: true

Logic
-----
The basic idea is from power of 2, We can use "n&(n-1) == 0" to determine if n is power of 2.
For power of 4, the additional restriction is that in binary form, the only "1" should always located
at the odd position. For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000.
So we can use "num & 0x55555555==num" to check if "1" is located at the odd position.

TC : o(1)
SC : o(1)
 */
public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(64));
    }
    public boolean isPowerOfFour(int num) {
        return (num>0) && ((num&(num-1))==0) && ((num&0x55555555)==num);
    }
}
