package com.string.manipulation;
/*
2264. Largest 3-Same-Digit Number in String

You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.


Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".

TC : o(n)
SC: o(1)
 */
public class Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        System.out.println(new Largest3SameDigitNumberInString().largestGoodInteger("6777133339"));
    }
    public String largestGoodInteger(String num) {
        char maxDigit = '\0';
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)== num.charAt(i+1) && num.charAt(i)== num.charAt(i+2)){
                maxDigit = (char) Math.max(maxDigit, num.charAt(i));
            }
        }
        return maxDigit == '\0' ? "" : new String(new char[]{maxDigit,maxDigit, maxDigit}) ;
    }
}
