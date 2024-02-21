package com.bit.manipulation;
/*
201. Bitwise AND of Numbers Range

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers
in this range, inclusive.

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0

TC : o(n)
SC: o(1)
 */
public class BitwiseANDOfNumbersRange {

    public static void main(String[] args) {
        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(5,12));
    }
    public int rangeBitwiseAnd(int left, int right) {
        /*
        start with right as when we do bitwise AND, it will always give smaller output
        hence, we can lower the right much faster to reach to left.
         */
        while(right>left){
            right &= (right-1);
        }
        return right&left;
    }
}
