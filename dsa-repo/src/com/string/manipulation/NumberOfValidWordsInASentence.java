package com.string.manipulation;
/*
2047. Number of Valid Words in a Sentence

A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'),
punctuation marks ('!', '.', and ','), and spaces (' ') only. Each sentence can be broken down into one or
more tokens separated by one or more spaces ' '.

A token is a valid word if all three of the following are true:

It only contains lowercase letters, hyphens, and/or punctuation (no digits).
There is at most one hyphen '-'. If present, it must be surrounded by lowercase characters
("a-b" is valid, but "-ab" and "ab-" are not valid).
There is at most one punctuation mark. If present, it must be at the end of the token
("ab,", "cd!", and "." are valid, but "a!b" and "c.," are not valid).
Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".

Given a string sentence, return the number of valid words in sentence.

Example 1:

Input: sentence = "cat and  dog"
Output: 3
Explanation: The valid words in the sentence are "cat", "and", and "dog".

TC : o(n)
SC : o(1)
 */
public class NumberOfValidWordsInASentence {

    public static void main(String[] args) {
        System.out.println(new NumberOfValidWordsInASentence().countValidWords("!this  1-s b8d!"));
    }
    public int countValidWords(String sentence) {
        int n = sentence.length();
        if(n==0)
            return 0;
        //Dont forget to use strip function to remove extra spaces at starting and end and then split about spaces


        String[] word = sentence.split("\\s+");

        int count =0;
        for(String s: word){
            //Check for each token if its valid
            if(isValid(s))
                count++;
        }

        return count;
    }

    private boolean isValid(String s){
        int hyphen =0;
        if(s.length()==0)
            return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //Digits are not allowed
            if(Character.isDigit(c))
                return false;
            //if lower case alphabet present then nothing to do
            if(Character.isLowerCase(c))
                continue;

            if(c=='-'){
                //more than one hyphen is invalid
                if(++hyphen>1)
                    return false;
                //hyphen should be sorrounded by lower case alphabets
                if(i-1 <0 || !Character.isLowerCase(s.charAt(i-1)) || i+1>= s.length()
                        || !Character.isLowerCase(s.charAt(i+1)))
                    return false;

            } else if(i!=s.length()-1)  //punctuation mark is allowed only at the end of token
                return false;

        }
        //all the conditions satisfied
        return true;
    }
}
