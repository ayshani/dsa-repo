package com.bit.manipulation;

import java.util.HashMap;
import java.util.Map;

/*
1915. Number of Wonderful Substrings

A wonderful string is a string where at most one letter appears an odd number of times.

For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

A substring is a contiguous sequence of characters in a string.



Example 1:

Input: word = "aba"
Output: 4
Explanation: The four wonderful substrings are underlined below:
- "aba" -> "a"
- "aba" -> "b"
- "aba" -> "a"
- "aba" -> "aba"

TC : o(N*10)
SC: o(N)
 */
public class NumberOfWonderfulSubstrings {

    public static void main(String[] args) {
        System.out.println(new NumberOfWonderfulSubstrings().wonderfulSubstrings("aba"));
    }
    public long wonderfulSubstrings(String word) {
        int n = word.length();

        // Create the frequency map
        // Key = bitmask, Value = frequency of bitmask key
        Map<Integer,Integer> freq = new HashMap<>();

        // The empty prefix can be the smaller prefix, which is handled like this
        freq.put(0,1);

        int mask = 0;
        long res = 0L;
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            int bit = c -'a';
            // Flip the parity of the c-th bit in the running prefix mask
            mask ^= (1<<bit);

            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment value associated with mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear
            // an odd number of times in a substring
            for(int oddC =0; oddC<10;oddC++){
                res += freq.getOrDefault(mask^(1<<oddC), 0);
            }
        }
        return res;
    }
}
