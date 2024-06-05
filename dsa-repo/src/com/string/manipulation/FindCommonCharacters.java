package com.string.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1002. Find Common Characters

Given a string array words, return an array of all characters that show up in all strings within the words
(including duplicates). You may return the answer in any order.

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

TC: o(n*m)
SC: o(26)
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"bella","label","roller"};
        System.out.println(new FindCommonCharacters().commonChars(words));
    }
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, 101);

        for(String word : words){
            int[] cur = new int[26];
            //Arrays.fill(cur, 101);
            for(int i=0;i<word.length();i++){
                cur[word.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++){
                count[i] = Math.min(count[i], cur[i]);
            }
        }

        for(char c = 'a' ; c<='z';c++){
            while(count[c-'a']-->0){
                res.add(""+c);
            }
        }
        return res;
    }
}
