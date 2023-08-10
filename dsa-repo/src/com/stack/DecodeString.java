package com.stack;

import java.util.Stack;

/*
394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are
well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits
are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
 */
public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
    public String decodeString(String s) {
        String result = "";
        Stack<String > st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==']'){
                String sectionInBracket ="";
                while(!st.isEmpty() && !st.peek().equals("[")){
                    sectionInBracket = st.pop() + sectionInBracket;
                }
                if(!st.isEmpty()){
                    st.pop();
                }

                String count ="";
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    count = st.pop() + count;
                }
                String repeatedSection = "";
                for(int j = 1; j<=Integer.parseInt(count); j++){
                    repeatedSection += sectionInBracket;
                }
                st.push(repeatedSection);
            } else{
                st.push(s.substring(i,i+1));
            }
        }
        while (!st.isEmpty())
            result = st.pop() + result;

        return result;
    }
}
