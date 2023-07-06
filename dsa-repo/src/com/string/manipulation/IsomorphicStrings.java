package com.string.manipulation;

import java.util.Arrays;

/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true

TC : o(n)
SC: o(1)
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg","add"));
    }
    public boolean isIsomorphic(String s, String t) {
        int[] mapS = new int[256], mapT = new int[256];
        Arrays.fill(mapS,-1);
        Arrays.fill(mapT,-1);
        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i), ct = t.charAt(i);
            if(mapS[cs]==-1 && mapT[ct]==-1){
                mapS[cs]=ct;
                mapT[ct]=cs;
            } else if(!(mapS[cs]==ct && mapT[ct]==cs)){
                return false;
            }
        }
        return true;
    }
}
