package com.backtracking;

import java.util.HashMap;
import java.util.Map;

/*
291. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection
between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dogcatcatdog"
Output: true

Logic
---------
two map pMap(char->string), sMap(string-> Char)
we will start dfs with 0th position (i,j)
    if by traversing both reach to end position -> true
    if by traversing either reach to end position -> false
    get the current character(c) of pattern and loop over the string
        get substring (j,k) => sub
        if pMap already has c and it doesn't map to sub -> continue
        if sMap already has sub and it doesn't map to c -> continue
        if none of the map contains
            add both mapping
        call recursion with i+1,k
        revert the addition of map

TC : o(n^n)
SC : o(n)
Ref :
https://www.youtube.com/watch?v=W9ohcDTkUko
 */
public class WordPatternII {

    Map<Character,String> pMap;
    Map<String,Character> sMap;

    public static void main(String[] args) {
        WordPatternII obj = new WordPatternII();
        //String pattern = "abba", s = "dogcatcatdog";
        String pattern = "aaaa", s = "dogcatcatdog";
        System.out.println(obj.wordPatternMatch(pattern,s));
    }

    public boolean wordPatternMatch(String pattern, String s){
        pMap = new HashMap<>();
        sMap = new HashMap<>();

         return dfs(pattern,0,s,0);
    }

    private boolean dfs(String pattern, int i, String s, int j) {
        if(i==pattern.length() && j==s.length())
            return true;
        if(i==pattern.length() || j==s.length())
            return false;

        char c = pattern.charAt(i);
        boolean insert = false;
        for(int k=j+1;k<=s.length();k++){
            String sub = s.substring(j,k);
            if(pMap.containsKey(c) && !pMap.get(c).equals(sub))
                continue;
            if(sMap.containsKey(sub) && sMap.get(sub) != c)
                continue;
            if(!pMap.containsKey(c) && !sMap.containsKey(sub)){
                pMap.put(c,sub);
                sMap.put(sub,c);
                insert = true;
            }
            if(dfs(pattern,i+1,s,k))
                return true;
            if(insert) {
                pMap.remove(c);
                sMap.remove(sub);
            }
        }
        return false;
    }
}
