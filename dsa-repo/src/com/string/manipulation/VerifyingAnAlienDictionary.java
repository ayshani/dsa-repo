package com.string.manipulation;
/*
953. Verifying an Alien Dictionary

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographically in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

TC : o(n*s)
SC: o(1)
 */
public class VerifyingAnAlienDictionary {

    int[] mapping;

    public static void main(String[] args) {
        String[] w = new String[]{"word","world","row"};
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(w,"worldabcefghijkmnpqstuvxyz"));
    }
    public boolean isAlienSorted(String[] words, String order) {
        mapping = new int[26];
        for(int i=0;i<order.length();i++){
            mapping[order.charAt(i) - 'a'] = i;
        }

        for(int i=1;i<words.length;i++){
            if(bigger(words[i-1],words[i]))
                return false;
        }
        return true;
    }

    private boolean bigger(String s1, String s2){
        int m = s1.length(), n = s2.length();
        for(int i=0;i<m && i<n; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
            }
        }
        return m>n;
    }
}
