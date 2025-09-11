package com.string.manipulation;

import java.util.*;

/*
2785. Sort Vowels in a String

Given a 0-indexed string s, permute s to get a new string t such that:

All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such
that s[i] is a consonant, then t[i] = s[i].
The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j
with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all
letters that are not vowels.

Example 1:

Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted
according to their ASCII values, and the consonants remain in the same places.

TC : o(nlogn)
SC: o(n)
 */
public class SortVowelsInAString {

    public static void main(String[] args) {
        System.out.println(new SortVowelsInAString().sortVowels("lYmpH"));
    }
    public String sortVowels(String s) {
        if(s==null || s.length()<2)
            return s;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        List<Character> sort = new ArrayList<>();
        char[] ch = s.toCharArray();
        for(char c: ch){
            if(vowels.contains(c))
                sort.add(c);
        }
        Collections.sort(sort);
        //System.out.println(sort);
        int index=0;
        for(int i=0;i<ch.length;i++){
            if(vowels.contains(ch[i])){
                ch[i] = sort.get(index);
                index++;
            }
        }

        return String.valueOf(ch);
    }

}
