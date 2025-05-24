package com.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
2942. Find Words Containing Character

You are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.



Example 1:

Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.

TC : o(n)
SC: o(1)
 */
public class FindWordsContainingCharacter {

    public static void main(String[] args) {
        System.out.println(new FindWordsContainingCharacter().findWordsContaining(
                new String[]{"leet","code"}, 'e'
        ));
    }
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words[i].contains(x+"")){
                list.add(i);
            }
        }
        return list;
    }
}
