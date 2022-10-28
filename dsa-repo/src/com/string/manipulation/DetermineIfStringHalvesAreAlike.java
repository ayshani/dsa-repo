package com.string.manipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1704. Determine if String Halves Are Alike

You are given a string s of even length. Split this string into two halves of equal lengths, and let a be
the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

TC : o(n)
SC : o(1)
 */
public class DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("textbook"));
    }
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int counter = 0;
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(set.contains(s.charAt(i))) counter++;
            if(set.contains(s.charAt(j))) counter--;
            i++;
            j--;
        }
        return counter == 0;
    }
}
