package com.string.manipulation;
/*
3614. Process String with Special Operations II

You are given a string s consisting of lowercase English letters and the special characters: '*', '#', and '%'.

You are also given an integer k.

Build a new string result by processing s according to the following rules from left to right:

If the letter is a lowercase English letter append it to result.
A '*' removes the last character from result, if it exists.
A '#' duplicates the current result and appends it to itself.
A '%' reverses the current result.
Return the kth character of the final string result. If k is out of the bounds of result, return '.'.



Example 1:

Input: s = "a#b%*", k = 1

Output: "a"

Explanation:

i	s[i]	Operation	Current result
0	'a'	Append 'a'	"a"
1	'#'	Duplicate result	"aa"
2	'b'	Append 'b'	"aab"
3	'%'	Reverse result	"baa"
4	'*'	Remove the last character	"ba"
The final result is "ba". The character at index k = 1 is 'a'.

TC : o(n)
SC: o(n)
 */
public class ProcessStringWithSpecialOperationsII {

    public static void main(String[] args) {
        System.out.println(new ProcessStringWithSpecialOperationsII().processStr("a#b%*", 1));
    }
    public char processStr(String s, long k) {
        long len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    if (len > 0) {
                        len--;
                    }
                    break;
                case '#':
                    len *= 2;
                    break;
                case '%':
                    break;
                default:
                    len++;
                    break;
            }
        }
        if (k + 1 > len) {
            return '.';
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case '*':
                    len++;
                    break;
                case '#':
                    if (k + 1 > (len + 1) / 2) {
                        k -= len / 2;
                    }
                    len = (len + 1) / 2;
                    break;
                case '%':
                    k = len - k - 1;
                    break;
                default:
                    if (k + 1 == len) {
                        return c;
                    }
                    len--;
                    break;
            }
        }
        return '.';
    }
}
