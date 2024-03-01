package com.string.manipulation;
/*
2864. Maximum Odd Binary Number

You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number
that can be created from this combination.
Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.



Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
TC : o(n)
SC: o(1)
 */
public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        System.out.println(new MaximumOddBinaryNumber().maximumOddBinaryNumber("0001010110"));
    }
    public String maximumOddBinaryNumber(String s) {
        int zeroCount =0, oneCount =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0')
                zeroCount++;
            else
                oneCount++;
        }

        if(oneCount==0)
            return s;

        StringBuilder sb = new StringBuilder("1");
        for(int i=0;i<zeroCount;i++){
            sb.append("0");
        }
        for(int i=0;i<oneCount-1;i++){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
