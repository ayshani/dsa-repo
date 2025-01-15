package com.bit.manipulation;
/*
2429. Minimize XOR

Given two positive integers num1 and num2, find the positive integer x such that:

x has the same number of set bits as num2, and
The value x XOR num1 is minimal.
Note that XOR is the bitwise XOR operation.

Return the integer x. The test cases are generated such that x is uniquely determined.

The number of set bits of an integer is the number of 1's in its binary representation.



Example 1:

Input: num1 = 3, num2 = 5
Output: 3
Explanation:
The binary representations of num1 and num2 are 0011 and 0101, respectively.
The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.

TC : o(logn)
SC: o(1)
 */
public class MinimizeXOR {

    public static void main(String[] args) {
        System.out.println(new MinimizeXOR().minimizeXor(3,5));
    }
    public int minimizeXor(int num1, int num2) {
        int result =0;
        int targetBitCount = Integer.bitCount(num2);
        int setbitCount =0;
        int currentBitCount = 31;

        while(setbitCount < targetBitCount){
            if(isSet(num1,currentBitCount ) || (targetBitCount - setbitCount > currentBitCount)){
                result = setBit(result, currentBitCount);
                setbitCount++;
            }
            currentBitCount--;
        }
        return result;
    }

    private boolean isSet(int x, int bit){
        return (x & (1<<bit)) !=0;
    }

    private int setBit(int x, int bit){
        return x | (1<<bit);
    }
}
