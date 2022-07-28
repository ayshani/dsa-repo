package com.string.manipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
266. Palindrome Permutation

Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Logic
----------
Use HashSet to traverse the string

If a letter is not in the HashSet, we add this letter,
If the letter already exists, we delete the letter,
So in the end, if there are no letters or only one letter in the HashSet, it means that it is a palindrome.

TC : O(n)
SC : o(n)
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePermutation().checkPalindromePermutation(s));
    }

    public boolean checkPalindromePermutation(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!set.contains(c))
                set.add(c);
            else {
                set.remove(c);
            }
        }

        return set.size()<2;
    }
}
