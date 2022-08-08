package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
1087.Brace-Expansion

A string S represents a list of words.

Each letter in the word has 1 or more options.
If there is one option, the letter is represented as is.
If there is more than one option, then curly braces delimit the options.
For example, "{a,b,c}" represents options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.

Example 1:
Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]

Example 2:
Input: "abcd"
Output: ["abcd"]

Note:
1 <= S.length <= 50
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.

Logic
-------
use backtracking for selecting one section in one brace.

TC : o(2^n)
SC : o(n)
 */
public class BraceExpansion {

    public static void main(String[] args) {
        String s = "{a,b}c{d,e}f";
        System.out.println(new BraceExpansion().getAllExpansions(s));
    }
    public List<String> getAllExpansions(String s){
        List<String> result = new ArrayList<>();

        helper(s,0,"" ,result);
        return result;
    }

    private void helper(String s, int start, String current, List<String> result) {
        if(start==s.length()){
            result.add(current);
            return;
        }
        // Get the index of first { after start position
        int left = s.indexOf('{',start);
        // get the index of first } after start position
        int right = s.indexOf('}',start);

        // Incase we don't get any index for left, that means the string doesn't contain
        // any further braces. so we can take the shole string and add to result.
        if(left == -1)
        {
            result.add(current + s.substring(start));
            return;
        }

        /*
        If the above condition doesn't hold, that means we have legitimate brace.
        so, we take the in between string of {  and } .
        split the string by comma .
         */
        String inBetweenBrace = s.substring(left+1,right);
        String[] split = inBetweenBrace.split(",");

        /*
        call for those each distinct section in the brace
         */
        for(String section : split){
            helper(s,right+1,current + s.substring(start,left) + section,result);
        }
    }
}
