package com.stack;

import java.util.Stack;

/*
1249. Minimum Remove to Make Valid Parentheses

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting
parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

TC : o(n)
SC : o(n)
 */
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)de)"));
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(sb.charAt(i)=='(')
                st.push(i);
            if(sb.charAt(i) == ')'){
                if(!st.isEmpty())
                    st.pop();
                else
                    sb.setCharAt(i,'*');
            }
        }

        while(!st.isEmpty()){
            sb.setCharAt(st.pop(),'*');
        }

        return sb.toString().replaceAll("\\*","");

    }
}
