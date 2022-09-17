package com.string.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
2131. Longest Palindrome by Concatenating Two Letter Words

You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order.
Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.



Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.

Explanation:

2 letter words can be of 2 types:

Where both letters are same
Where both letters are different
Based on the above information:

If we are able to find the mirror of a word, ans += 4
The variable unpaired is used to store the number of unpaired words with both letters same.
Unpaired here means a word that has not found its mirror word.
At the end if unpaired same letter words are > 0, we can use one of them as the center of the palindromic string.

TC : o(n)
SC : o(n)
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String[] words = new String[]{"ab","ty","yt","lc","cl","ab"};
        System.out.println(new LongestPalindromeByConcatenatingTwoLetterWords().longestPalindrome(words));
    }
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int answer =0, unpaired=0;
        for(String word : words){
            if(!map.containsKey(word))
                map.put(word,0);

            if(word.charAt(0)==word.charAt(1)){
                if(map.get(word)>0){
                    unpaired--;
                    answer+=4;
                    map.put(word,map.get(word)-1);
                } else{
                    map.put(word,map.get(word)+1);
                    unpaired++;
                }
            } else{
                String rev = Character.toString(word.charAt(1)) + Character.toString(word.charAt(0));
                if(map.containsKey(rev) && map.get(rev)>0){
                    answer+=4;
                    map.put(rev,map.get(rev)-1);
                } else{
                    map.put(word,map.get(word)+1);
                }
            }
        }

        return unpaired > 0 ? answer+2 : answer;
    }

}
