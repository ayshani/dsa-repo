package com.stack;

import java.util.Stack;

/*
678. Valid Parenthesis String
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true

TC : o(n)
SC: o(n)

 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(new ValidParenthesisString().
       checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        int starCount =0;

        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur=='('){
                st.push(i);
            } else if(cur == ')'){
                if(!st.isEmpty()){
                    st.pop();
                } else if(!asterisk.isEmpty()){
                    asterisk.pop();
                } else{
                    return false;
                }
            } else{
                asterisk.push(i);
            }
        }
        // Check if there are remaining open brackets and asterisks that can balance
        //them
        while(!st.isEmpty() &&  !asterisk.isEmpty()){
            // If an open bracket appears after an asterisk, it cannot be balanced, return false
            if(st.pop()>asterisk.pop()){
                return false; // '*' before '(' which cannot be balanced.
            }
        }
        // If all open brackets are matched and there are no unmatched
        //open brackets left, return true
        return st.isEmpty() ;
    }
}
