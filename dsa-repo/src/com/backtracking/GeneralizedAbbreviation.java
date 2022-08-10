package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
320 - Generalized Abbreviation

 A word's generalized abbreviation can be constructed by taking any number of non-overlapping substrings and
 replacing them with their respective lengths.
 For e.g. "abcde" can be abbreviated into "a3e" ("bcd" turned into "3"), 1bcd1("a" and "e" both turned into "1"),
 "23" ( "ab" turned into "2" and "cde" turned into "3").

 Given a String s, return a list of all possible abbreviations of s. Return the answer in any order.

 Example:

 Given word = "word", return the following list (order does not matter):

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Logic
-------
If you write a binary number from 0 to 15, each binary can correspond to a situation, as shown below:

0000 word 0001 wor1 0010 wo1d 0011 wo2 0100 w1rd 0101 w1r1 0110 w2d 0111 w3 1000 1ord 1001 1or1 1010 1o1d 1011 1o2
1100 2rd 1101 2r1 1110 3d 1111 4


Then we can observe the law, wherever 0 is the original letter, and a single 1 is still 1.
If there are several 1s connected together, the number of 1s is required,
and this number is used to replace the corresponding letter.

TC : o(2^n)
SC : o(2^n)
 */
public class GeneralizedAbbreviation {

    public static void main(String[] args) {
        System.out.println(new GeneralizedAbbreviation().generateAbbreviations("word"));
    }
    public List<String> generateAbbreviations(String s){
        List<String> result = new ArrayList<>();
        result.add(s);
        dfs(0,s,result);
        return result;
    }

    private void dfs(int start, String s, List<String> result){
        if(start>=s.length())
            return;

        for(int i=start;i<s.length();i++){
            for(int j=1;j+i<=s.length();j++){
                String num = Integer.toString(j);
                String currentAbbreviation = s.substring(0,i) + num + s.substring(i+j);
                result.add(currentAbbreviation);
                dfs(i+1+num.length(),currentAbbreviation,result);
            }
        }
    }
}
