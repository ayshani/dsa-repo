package com.string.manipulation;
/*
344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

TC: o(n)
SC: o(1)
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = new char[]{'h','e','l','l','o'};
        new ReverseString().reverseString(s);
        System.out.println(String.valueOf(s));
    }
    public void reverseString(char[] s) {
        int i=0,j = s.length-1;

        while(i<j){
            char temp = s[i];
            s[i] =s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
