package com.bit.manipulation;

import java.util.Arrays;

/*
338. Counting Bits

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i]
is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
 */
public class CountingBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(7)));
    }
    public int[] countBits(int n) {
        int[] f = new int[n+1];
        for(int i=1; i<=n;i++){
            /*
            Even - 10, 100,110 :  it always has one 0 in its LSB. so, if we do
                   right shift by one position it doesnot matter. Again, if we do
                   i&1, it always yeilds 0.
            Odd - 1,11,101 : it always has 1 in its LSB. so, if we do right shift,
                   one loose one 1. Hence we do i&1 which yeilds to 1.

            The ides of doing right shift is to get the already computed result to be used for. for e.g : 110, we can get result of 11 and try.
            */
            f[i] = f[i>>1]+ (i&1);
        }
        return f;
    }
}
