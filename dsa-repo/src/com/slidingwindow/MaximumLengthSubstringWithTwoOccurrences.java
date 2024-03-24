package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
3090. Maximum Length Substring With Two Occurrences

Given a string s, return the maximum length of a
substring
 such that it contains at most two occurrences of each character.


Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:

The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".

TC : o(n)
SC: o(26)
 */
public class MaximumLengthSubstringWithTwoOccurrences {

    public static void main(String[] args) {
        System.out.println(new MaximumLengthSubstringWithTwoOccurrences().maximumLengthSubstring("bcbbbcba"));
    }
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int start =0, maxLength =0;;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            } else{
                int count = map.get(c);
                count++;
                while(count>2){
                    char startC = s.charAt(start);
                    if(startC==c)
                        count--;
                    map.put(startC,map.get(startC)-1);
                    start++;
                }
                map.put(c, count);
            }
            int length = i- start+1;
            maxLength = Math.max(maxLength, length);

        }
        return maxLength;
    }

}
