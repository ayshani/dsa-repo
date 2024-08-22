package com.bit.manipulation;
/*
476. Number Complement

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in
its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.



Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you
need to output 2.

TC : o(1)
SC: o(1)

Logic :  input: 5 = 0...0101(+)
 * output: 2 = 0...0010(+)
 * input + output = 0...0111(+)
 * ~5 = 1..1010 (-)（all bits inverse）
 *
 (Integer.highestOneBit(num) << 1) - 1 //it's mean 1000-1=0..0111(+)
 ~5 & (Integer.highestOneBit(num) << 1) - 1  //result is  0...0 010

 */
public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }
    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num)-1);
    }

}
