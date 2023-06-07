package com.bit.manipulation;

import java.util.Arrays;

/*
1318. Minimum Flips to Make a OR b Equal to c

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.



Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 */
public class MinimumFlipsToMakeaORbEqualToc {

    public static void main(String[] args) {
        System.out.println(new MinimumFlipsToMakeaORbEqualToc().minFlips(2,6,5));
    }
    public int minFlips(int a, int b, int c) {
        boolean[] A = getBits(a);
        boolean[] B = getBits(b);
        boolean[] C = getBits(c);
        int counter = 0;
        for (int i = 0; i < 32; i++) {
            // OR result is not similar to C
            // count++
            if ((A[i] | B[i]) != C[i]) counter++;
            // if bit A, B are 1 and C is false,
            // in this case, we need to count one more after about count
            if ((A[i] & B[i]) && C[i] == false) counter++;
        }
        return counter;
    }

    /**
     Returns the bits array of x.
     */
    private boolean[] getBits(int x) {
        boolean[] bits = new boolean[32];
        for (int i = 0; x != 0 && i < 32; i++) {
            bits[31 - i] = x % 2 == 1 ? true : false;
            x /= 2;
        }
        System.out.println(Arrays.toString(bits));
        return bits;
    }
}
