package com.stack;

import java.util.Stack;

/*
316. Remove Duplicate Letters

Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
your result is
the smallest in lexicographical order
 among all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"

TC : o(n)
SC: o(n)
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i=0;i<s.length();i++){
            // track the lastIndex of character presence
            lastIndex[s.charAt(i)-'a']=i;
        }

        // keep track seen
        boolean[] seen = new boolean[26];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            int cur = s.charAt(i) - 'a';
            // if seen continue as we need to pick one char only
            if(seen[cur])
                continue;

            // pop out and mark unseen
            while(!st.isEmpty() && st.peek() > cur && i< lastIndex[st.peek()]){
                seen[st.pop()]= false;
            }

            // add into stack
            st.push(cur);
            // mark seen
            seen[cur] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.reverse().toString();
    }
}
