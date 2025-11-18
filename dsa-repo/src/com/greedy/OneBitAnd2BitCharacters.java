package com.greedy;
/*
717. 1-bit and 2-bit Characters

We have two special characters:

The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.



Example 1:

Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.


 */
public class OneBitAnd2BitCharacters {

    public static void main(String[] args) {
        System.out.println(new OneBitAnd2BitCharacters().isOneBitCharacter(new int[]{1,0,0}));
    }
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }
}
