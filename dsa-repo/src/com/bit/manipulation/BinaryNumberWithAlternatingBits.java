package com.bit.manipulation;
/*
693. Binary Number with Alternating Bits

Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.



Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.


TC : o(1) // given bits for integer cna be of 32 bits only
SC: o(1)
 */
public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(11));
    }
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);
        for(int i=0;i<bits.length()-1;i++){
            if(bits.charAt(i) == bits.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
}
