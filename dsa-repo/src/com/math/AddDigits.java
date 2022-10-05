package com.math;
/*
258. Add Digits

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.

Logic
------
Formula for the Digital Root

There is a known formula to compute a digital root in a decimal numeral system
dr_10(n) = 0, if n = 0
dr_10(n) = 9 , if n = 9k
dr_10(n) =n mod 9 , if n != 9k


TC : o(1)
SC : o(1)
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(56));
    }
    public int addDigits(int n) {
        if(n==0)
            return 0;
        if(n%9==0)
            return 9;
        return n%9;
    }
}
