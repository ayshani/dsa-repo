package com.bit.manipulation;
/*
1009. Complement of Base 10 Integer

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.



Example 1:

Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.

TC : o(n)
SC: o(1)
 */
public class ComplementOfBase10Integer {

    public static void main(String[] args) {
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(5));
    }
    public int bitwiseComplement(int n) {
        int x =1;
        while(n>x){
            x = x*2+1;
        }
        return x-n;
    }
}
