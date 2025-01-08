package com.string.manipulation;
/*
3042. Count Prefix and Suffix Pairs I

You are given a 0-indexed string array words.

Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:

isPrefixAndSuffix(str1, str2) returns true if str1 is both a
prefix
 and a
suffix
 of str2, and false otherwise.
For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.

Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.



Example 1:

Input: words = ["a","aba","ababa","aa"]
Output: 4
Explanation: In this example, the counted index pairs are:
i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
Therefore, the answer is 4.

TC : o(n^2 * len(str1))
SC: o(1)
 */
public class CountPrefixAndSuffixPairsI {

    public static void main(String[] args) {
        System.out.println(new CountPrefixAndSuffixPairsI().countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"}));
    }
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length, count=0;
        for(int i=0;i<n;i++){
            String word1 = words[i];
            for(int j=i+1;j<n;j++){
                String word2 = words[j];

                if(isSamePrefixSuffix(word1, word2))
                    count++;
            }
        }
        return count;
    }

    private boolean isSamePrefixSuffix(String word1, String word2){
        if(word2.startsWith(word1) && word2.endsWith(word1))
            return true;
        return false;
    }
}
