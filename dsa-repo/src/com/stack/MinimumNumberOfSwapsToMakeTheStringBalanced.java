package com.stack;

import java.util.Stack;

/*
1963. Minimum Number of Swaps to Make the String Balanced

You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets
'[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:

It is the empty string, or
It can be written as AB, where both A and B are balanced strings, or
It can be written as [C], where C is a balanced string.
You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.



Example 1:

Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
 */
public class MinimumNumberOfSwapsToMakeTheStringBalanced {

    public static void main(String[] args) {
        /*
        Input: s = "]]][[["
        Output: 2
        Explanation: You can do the following to make the string balanced:
        - Swap index 0 with index 4. s = "[]][][".
        - Swap index 1 with index 5. s = "[[][]]".
        The resulting string is "[[][]]".
         */
        System.out.println(new MinimumNumberOfSwapsToMakeTheStringBalanced().minSwaps("]]][[["));
    }
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='['){
                st.push(c);
            } else if(!st.isEmpty()){
                st.pop();
            }
        }

        // here we are doing +1 to take into account of odd length of stack
        // for eg: if stack size ==2 : 2/2 ==1 -> here there ll be no problem.
        // but for eg stack size==3 : 3/2 ==1 -> it is a problem, as min no. of swap for 3
        // misbalanced open/closed brace is 2. and 3/2 ll not give 2. hence, 1 is added.
        return (st.size()+1)/2;
    }
}
