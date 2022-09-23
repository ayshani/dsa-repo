package com.math;
/*
1680. Concatenation of Consecutive Binary Numbers

Given an integer n, return the decimal value of the binary string formed by concatenating
the binary representations of 1 to n in order, modulo 109 + 7.

Example 1:

Input: n = 1
Output: 1
Explanation: "1" in binary corresponds to the decimal value 1.
Example 2:

Input: n = 3
Output: 27
Explanation: In binary, 1, 2, and 3 corresponds to "1", "10", and "11".
After concatenating them, we have "11011", which corresponds to the decimal value 27.

Logic
-------
n = 3
1 - 1
2 - 10
3 - 11

123 -> 11011 -->

(1 * 2^4) + (1 * 2 ^3 + 0 * 2 ^ 2) + (1 * 2^1 + 1 * 2^0)

(1 * 2^4) + (2 * 2 ^2 + 0 * 2 ^ 2) + (2 * 2^0 + 1 * 2^0)

(1 * 2^4) + (2 + 0) * 2 ^2  + (2 + 1)* 2^0

(1)* 2^4 + (2) * 2 ^2  + (3)* 2^0

((1)* 2^4 + (2) * 2 ^2)  + (3)* 2^0

((1)* 2^2 + (2)) * 2 ^2)  + (3)* 2^0

(4 + 2) * 2^2 + 3

24 + 3

27

TC : o(n)
SC : o(1)
 */
public class ConcatenationOfConsecutiveBinaryNumbers {

    public static void main(String[] args) {
        System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(12));
    }
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long sum =0;
        for(int i=1;i<=n;i++){
            sum = (sum*(int)Math.pow(2,Integer.toBinaryString(i).length()) + i )%mod;
        }

        return (int)sum;
    }
}
