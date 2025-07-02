package com.dp;

import java.util.ArrayList;
import java.util.List;

/*
3333. Find the Original Typed String II

Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

You are given a string word, which represents the final output displayed on Alice's screen. You are also given a positive integer k.

Return the total number of possible original strings that Alice might have intended to type, if she was trying to type a string of size at least k.

Since the answer may be very large, return it modulo 109 + 7.



Example 1:

Input: word = "aabbccdd", k = 7

Output: 5

Explanation:

The possible strings are: "aabbccdd", "aabbccd", "aabbcdd", "aabccdd", and "abbccdd".

TC : o(k*min(n,k))
SC : o(n)
 */
public class FindTheOriginalTypedStringII {

    public static void main(String[] args) {
        System.out.println(new FindTheOriginalTypedStringII().possibleStringCount("aabbccdd", 7));
    }
    public int possibleStringCount(String word, int k) {
        final int MODULO = (int) (1e9 + 7);
        int wordLength = word.length();
        List<Integer> characterGroups = new  ArrayList<>();

        for (int index = 0; index < wordLength;) {
            int characterCount = 1;
            char currentCharacter = word.charAt(index++);
            while (index < wordLength && word.charAt(index) == currentCharacter) {
                characterCount++;
                index++;
            }
            characterGroups.add(characterCount);
        }

        long totalCombinations = 1;
        for (int groupCount : characterGroups) {
            totalCombinations = (totalCombinations * groupCount) % MODULO;
        }

        if (k <= characterGroups.size()) {
            return (int) totalCombinations;
        }

        int maxSize = k - 1;
        int[] dp = new int[maxSize + 1];
        dp[0] = 1;

        for (int count : characterGroups) {
            int[] newDP = new int[maxSize + 1];
            long cumulativeSum = 0;
            for (int s = 0; s <= maxSize; s++) {
                if (s - 1 >= 0) cumulativeSum = (cumulativeSum + dp[s - 1]) % MODULO;
                if (s - count - 1 >= 0) cumulativeSum = (cumulativeSum - dp[s - count - 1] + MODULO) % MODULO;
                newDP[s] = (int) cumulativeSum;
            }
            dp = newDP;
        }
        long totalLessThanK = 0;
        for (int s = characterGroups.size(); s <= maxSize; s++) {
            totalLessThanK = (totalLessThanK + dp[s]) % MODULO;
        }

        return (int) ((totalCombinations - totalLessThanK + MODULO) % MODULO);

    }
}
