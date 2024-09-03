package com.string.manipulation;
/*
1945. Sum of Digits of String After Convert

You are given a string s consisting of lowercase English letters, and an integer k.

First, convert s into an integer by replacing each letter with its position in the alphabet
(i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the
sum of its digits. Repeat the transform operation k times in total.

For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:

Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
Transform #2: 17 ➝ 1 + 7 ➝ 8
Return the resulting integer after performing the operations described above.



Example 1:

Input: s = "iiii", k = 1
Output: 36
Explanation: The operations are as follows:
- Convert: "iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
- Transform #1: 9999 ➝ 9 + 9 + 9 + 9 ➝ 36
Thus the resulting integer is 36.

TC : o(n)
SC: o(1)
 */
public class SumOfDigitsOfStringAfterConvert {

    public static void main(String[] args) {
        System.out.println(new SumOfDigitsOfStringAfterConvert().getLucky("iiii",1));
    }
    public int getLucky(String s, int k) {
        String numericString = "";
        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        while (k-- > 0) {
            int digitSum = 0;
            for (char digit : numericString.toCharArray()) {
                digitSum += digit - '0';
            }
            numericString = Integer.toString(digitSum);
        }
        // Convert the final string to integer and return
        return Integer.parseInt(numericString);
    }
}
