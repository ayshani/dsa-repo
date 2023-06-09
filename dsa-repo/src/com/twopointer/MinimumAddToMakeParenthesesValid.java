package com.twopointer;
/*
921. Minimum Add to Make Parentheses Valid

A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a
closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.



Example 1:

Input: s = "())"
Output: 1

TC: o(n)
SC: o(1)
 */
public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {
        System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid("())"));
    }
    public int minAddToMakeValid(String s) {
        int right =0, left =0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                right++;
            }else if(right>0){
                right--;
            }else{
                left++;
            }
        }

        return right+ left;
    }
}
