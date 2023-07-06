package com.stack;

import java.util.Stack;

/*
1047. Remove All Adjacent Duplicates In String

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing
two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only
possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the
final string is "ca".

TC : o(n)
SC : o(n)
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("azxxzy"));
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicatesV2("azxxzy"));
    }
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i))
                    st.pop();
                else
                    st.push(s.charAt(i));
            } else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }

    public String removeDuplicatesV2(String s) {
        char[] res = s.toCharArray();
        int i=0;
        for(int j=0;j<s.length();j++,i++){
            res[i]= res[j];
            if(i>0 && res[i-1]==res[i]){
                i-=2;
            }
        }
        return new String(res,0,i);
    }
}
