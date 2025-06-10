package com.map;

import java.util.HashMap;
import java.util.Map;

/*
3442. Maximum Difference Between Even and Odd Frequency I

You are given a string s consisting of lowercase English letters.

Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:

a1 has an odd frequency in the string.
a2 has an even frequency in the string.
Return this maximum difference.



Example 1:

Input: s = "aaaaabbc"

Output: 3

Explanation:

The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.

TC : o(n)
SC: o(n)
 */
public class MaximumDifferenceBetweenEvenAndOddFrequencyI {

    public static void main(String[] args) {
        System.out.println(new MaximumDifferenceBetweenEvenAndOddFrequencyI().maxDifference("aaaaabbc"));
    }
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int maxOdd =1, minEven =s.length();
        for(int value : map.values()){
            if(value %2 == 1){
                maxOdd = Math.max(maxOdd, value);
            } else {
                minEven = Math.min(minEven, value);
            }
        }
        return maxOdd - minEven;
    }
}
