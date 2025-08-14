package com.math;
/*
326. Power of Three

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:

Input: n = 27
Output: true

TC : o(logn)
SC : o(1)
 */
public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(27));
    }
    public boolean isPowerOfThree(int n) {
        if(n<1)
            return false;
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
}
