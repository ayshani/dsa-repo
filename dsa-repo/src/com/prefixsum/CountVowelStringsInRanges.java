package com.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
2559. Count Vowel Strings in Ranges

You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].

TC : o(m+n)
SC: o(n)
 */
public class CountVowelStringsInRanges {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountVowelStringsInRanges().vowelStrings(
                new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}}
        )));
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );

        int[] prefixSum = new int[words.length];
        int sum =0;
        for(int i=0; i<words.length;i++){
            String currentWord = words[i];
            if(vowels.contains(currentWord.charAt(0)) &&
                    vowels.contains(currentWord.charAt(currentWord.length() - 1))
            ) {
                sum++;
            }
            prefixSum[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            ans[i] =
                    prefixSum[currentQuery[1]] -
                            (currentQuery[0] == 0 ? 0 : prefixSum[currentQuery[0] - 1]);
        }

        return ans;
    }
}
