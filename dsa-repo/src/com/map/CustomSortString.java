package com.map;
/*
791. Custom Sort String

You are given two strings order and s. All the characters of order are unique and were sorted in some custom order
previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x
occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.



Example 1:

Input:  order = "cba", s = "abcd"

Output:  "cbad"

Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".

Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda"
are also valid outputs.

TC : o(n)
SC: o(n)
 */

import java.util.Map;
import java.util.HashMap;

public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba","abcdef"));
    }

    public String customSortString(String order, String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        for(char c : map.keySet()){
            int count = map.get(c);
            while(count>0){
                sb.append(c);
                count--;
            }
        }

        return String.valueOf(sb);
    }
}
