package com.set;

import java.util.HashSet;
import java.util.Set;

/*
3136. Valid Word

A word is considered valid if:

It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.

Return true if word is valid, otherwise, return false.

Notes:

'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
A consonant is an English letter that is not a vowel.


Example 1:

Input: word = "234Adas"

Output: true

Explanation:

This word satisfies the conditions.

TC : o(n)
SC: o(n)

 */
public class ValidWord {

    public static void main(String[] args) {
        System.out.println(new ValidWord().isValid("234Adas"));
    }
    public boolean isValid(String word) {
        int len = word.length();
        if(len<3)
            return false;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        Set<Character> specialCharacters = new HashSet<>();
        specialCharacters.add('@');
        specialCharacters.add('#');
        specialCharacters.add('$');

        int vowelCount =0, consonantCount =0, specialCharacterCount=0;

        for(int i=0;i<len;i++){
            char c = word.charAt(i);

            if(vowels.contains(c)){
                vowelCount++;
            } else if(specialCharacters.contains(c)){
                specialCharacterCount++;
            } else if( Character.isDigit(c)){
                continue;
            } else{
                consonantCount++;
            }
        }
        return vowelCount>0 && consonantCount>0 && specialCharacterCount==0;
    }
}
