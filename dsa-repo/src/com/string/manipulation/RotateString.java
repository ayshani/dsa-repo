package com.string.manipulation;
/*
796. Rotate String

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
TC : o(n)
SC: o(1)
 */
public class RotateString {

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
    }
    public boolean rotateString(String s, String goal) {
        // Check if the lengths are different
        if (s.length() != goal.length()) return false;

        // Create a new string by concatenating 's' with itself
        String doubledString = s + s;

        // Use contains to search for 'goal' in 'doubledString'
        // If contains return true, 'goal' is a substring
        return doubledString.contains(goal);
    }
}
