package com.string.manipulation;

import java.util.Stack;

/*
844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c","ad#c"));
    }
    public boolean backspaceCompare(String s, String t) {
        if(s.length() == 0 || t.length() == 0)
            return false;

        String one = getProperString(s);
        String sec = getProperString(t);

        if(one.equals(sec))
            return true;

        return false;

    }

    public String getProperString(String s){
        String result = "";
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) !='#')
                st.push(s.charAt(i));
            else{
                if(!st.isEmpty())
                    st.pop();
            }
        }


        return String.valueOf(st);
    }
}
