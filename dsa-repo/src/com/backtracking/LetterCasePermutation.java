package com.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
784. Letter Case Permutation

Given a string s, you can transform every letter individually
to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]

Logic
------
have two index both starting from 0 and one temp out char[] array.
if current character is a digit, then add to out[] and go ot next index.
else go for lowercase character then backtrack. go for uppercase character.

once out[] array and input array are traversed , add it to one set for not getting duplicates.

TC : o(n + 2^n) == o(2^n)
SC : o(n)

 */
public class LetterCasePermutation {
    Set<String> hs;

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }
    public List<String> letterCasePermutation(String s) {
        hs = new HashSet<>();

        helper(s.toCharArray(),0,new char[s.length()],0);

        return new ArrayList<>(hs);
    }

    private void  helper(char[] s,int i, char[] out, int j){
        if(i==s.length && j== s.length){
            hs.add(String.valueOf(out));
            return;
        }

        if(Character.isDigit(s[i])){
            out[j] = s[i];
            helper(s,i+1,out,j+1);
        }

        out[j]= Character.toLowerCase(s[i]);
        helper(s,i+1,out,j+1);
        out[j]= Character.toUpperCase(s[i]);
        helper(s,i+1,out,j+1);
    }

}
