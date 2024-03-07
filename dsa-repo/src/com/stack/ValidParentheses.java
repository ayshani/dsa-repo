package com.stack;

import java.util.Stack;

/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

TC: o(n)
SC: o(n)
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        if( s==null  ||s.length()==0 )
            return true;
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            } else{
                if(st.peek()=='(' && s.charAt(i)==')'){
                    st.pop();
                } else if(st.peek()=='{' && s.charAt(i)=='}'){
                    st.pop();
                } else if(st.peek()=='[' && s.charAt(i)==']'){
                    st.pop();
                } else
                    st.push(s.charAt(i));
            }
        }

        return st.isEmpty();
    }
}
