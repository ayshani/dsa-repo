package com.string.manipulation;
/*
3110. Score of a String

You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII
values of adjacent characters.

Return the score of s.



Example 1:

Input: s = "hello"

Output: 13

Explanation:

The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would
be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.


TC : o(n)
SC: o(1)

 */
public class ScoreOfAString {

    public static void main(String[] args) {
        System.out.println(new ScoreOfAString().scoreOfString("hello"));
    }
    public int scoreOfString(String s) {
        int n = s.length();
        int sum = 0;
        //System.out.println(sum);

        for(int i=1;i<n;i++){
            sum += Math.abs(s.charAt(i-1) - s.charAt(i));
        }
        return sum;
    }
}
