package com.string.manipulation;
/*
1903. Largest Odd Number in String

You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
 */
public class LargestOddNumberInString {

    public static void main(String[] args) {
        System.out.println(new LargestOddNumberInString().largestOddNumber("5234819"));
    }
    public String largestOddNumber(String num) {

        for(int i=num.length()-1;i>=0;i--){
            if(Character.getNumericValue(num.charAt(i))%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
