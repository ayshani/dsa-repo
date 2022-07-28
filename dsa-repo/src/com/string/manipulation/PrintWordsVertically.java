package com.string.manipulation;

import java.util.ArrayList;
import java.util.List;

/*
 * 1324. Print Words Vertically
 *
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word.


Example 1:

Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically.
 "HAY"
 "ORO"
 "WEU"


 Logic
 ------

 get the max Length of a word after splitting the string by " ";
 Iterate over this maxLength
 -> for every iteration, loop over the words array.
 	take word.charAt(i) if i<maxLength and append it to stringBuilder.
 	else append " " to the stringBuilder.
 	add this stringBuilder obj to list

TC : O(N^2)
SC : O(1)

 */
public class PrintWordsVertically {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "HOW ARE YOU";
        String s1 = "TO BE OR NOT TO BE";
        PrintWordsVertically obj = new PrintWordsVertically();
        System.out.println(obj.printVertically(s1));

    }


    public List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] words = s.split(" ");
        int max =0;
        for(int i=0;i<words.length;i++){
            max = Math.max(max, words[i].length());
        }

        for(int i=0;i<max;i++){
            StringBuilder sb = new StringBuilder();
            for(String word : words)
            {
                sb.append(i<word.length() ? word.charAt(i) : " ");
            }
            while (sb.charAt(sb.length() - 1) == ' ')
                sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }

        return result;
    }
}

