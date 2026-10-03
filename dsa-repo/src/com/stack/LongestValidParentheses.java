package com.stack;

import java.util.Stack;

/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.



Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

TC : o(n)
SC: o(n)
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
    }
    public int longestValidParentheses(String s) {
        if(s == "")
            return 0;

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')' && st.peek() !=-1 &&  s.charAt(st.peek()) == '(' ){
                st.pop();
                result = Math.max(result, i-st.peek());
            } else{
                st.push(i);
            }
        }

        return result;
    }
}
