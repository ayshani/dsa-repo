package com.map;

import java.util.HashMap;
import java.util.Map;

/*
771. Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and stones representing the
stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones
you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3


TC: o(n)
SC: o(n)
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA","AaAAbbbb"));
    }
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> stoneMap = new HashMap<>();

        for(int i=0;i<stones.length();i++){
            stoneMap.put(stones.charAt(i), stoneMap.getOrDefault(stones.charAt(i), 0)+1);
        }
        int sum =0;
        for(int i=0;i<jewels.length();i++){
            if(stoneMap.containsKey(jewels.charAt(i))){
                sum+=stoneMap.get(jewels.charAt(i));
            }
        }
        return sum;
    }
}
