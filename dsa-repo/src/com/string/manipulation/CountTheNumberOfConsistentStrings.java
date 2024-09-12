package com.string.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
1684. Count the Number of Consistent Strings

You are given a string allowed consisting of distinct characters and an array of strings words. A string is
consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.



Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

TC : o(m+ n*k)
SC: o(m)
 */
public class CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfConsistentStrings().countConsistentStrings(
                "ab", new String[]{"ad","bd","aaab","baa","badab"}
        ));
    }
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedCharacters = new HashSet<>();
        for(char c: allowed.toCharArray()){
            allowedCharacters.add(c);
        }
        int total =0;
        for(String word : words){
            int count = word.length();
            for(char c : word.toCharArray()){
                if(allowedCharacters.contains(c)){
                    count--;
                }else{
                    break;
                }
            }
            if(count==0){
                total++;
            }
        }
        return total;
    }
}
