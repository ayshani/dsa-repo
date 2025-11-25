package com.math;
/*
1015. Smallest Integer Divisible by K

Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.

Return the length of n. If there is no such n, return -1.

Note: n may not fit in a 64-bit signed integer.



Example 1:

Input: k = 1
Output: 1
Explanation: The smallest answer is n = 1, which has length 1.

TC : o(k)
SC: o(1)
 */
public class SmallestIntegerDivisibleByK {

    public static void main(String[] args) {
        System.out.println(new SmallestIntegerDivisibleByK().smallestRepunitDivByK(1));
    }
    public int smallestRepunitDivByK(int k) {
        int remainder =0;
        for(int length_n = 1; length_n<=k; length_n++){
            remainder = (remainder *10 +1) %k;
            if(remainder == 0 ){
                return length_n;
            }
        }
        return -1;
    }
}
