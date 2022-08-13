package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
30. Substring with Concatenation of All Words

You are given a string s and an array of strings words of the same length.
Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
in any order, and without any intervening characters.

You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

TC : o(a+ n*b)
where a = total number of words in array word[]
n = length of string s
b = each word length

SC : o(a+b)
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        Map<String,Integer> wordsCount = new HashMap<>();

        // keep counts of all words in a map
        for(String word : words){
            wordsCount.put(word, wordsCount.getOrDefault(word,0)+1);
        }

        int wordLength = words[0].length(), sLength = s.length();
        int numberOfWords = words.length;

        /*
        Iterate over the whole string s till there exist one last window size of
        total words length.
        Get the substring window size of total word length and check if
        we can get the concatenated string from substring to words.
        If yes, add the ith index in result.
         */
        for(int i=0;i<sLength - numberOfWords*wordLength + 1; i++){
            String sub = s.substring(i, i+ numberOfWords*wordLength);

            if(canConcat(sub,wordsCount,wordLength)){
                result.add(i);
            }
        }

        return result;
    }

    /*
    This method checks if the count map where we have kept the words with its occurrence count
    matches the current windows similar substring words with occurrence count.
    that means, we take the substring of each word length and put it in another map named 'seen'.
    once the iteration is over, we check the equality of both count and seen map.
     */
    private boolean canConcat(String sub,Map<String,Integer> wordsCount,int wordLength){

        Map<String,Integer> seen = new HashMap<>();

        for(int i=0;i<sub.length();i+=wordLength){
            String wordLengthSub = sub.substring(i,i+wordLength);
            seen.put(wordLengthSub, seen.getOrDefault(wordLengthSub,0)+1);
        }

        return seen.equals(wordsCount);
    }

}
