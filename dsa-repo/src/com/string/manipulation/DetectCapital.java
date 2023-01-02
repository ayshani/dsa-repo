package com.string.manipulation;
/*
520. Detect Capital

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.



Example 1:

Input: word = "USA"
Output: true

TC : o(n)
SC : o(1)
 */
public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("FlaG"));
    }
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        boolean match = false;

        // case 1 : All caps
        for(int i=0;i<n;i++){
            if(!Character.isUpperCase(word.charAt(i))){
                match = false;
                break;
            }else
                match = true;
        }

        if(match)
            return true;

        match = false;

        // case 2 : all Small
        for(int i=0;i<n;i++){
            if(!Character.isLowerCase(word.charAt(i))){
                match = false;
                break;
            }else
                match = true;
        }

        if(match)
            return true;

        // case 3: Camel case
        if(!Character.isUpperCase(word.charAt(0))){
            return false;
        }

        match = false;
        for(int i=1;i<n;i++){
            if(!Character.isLowerCase(word.charAt(i))){
                match = false;
                break;
            }else
                match = true;
        }

        if(match)
            return true;

        return false;
    }
}
