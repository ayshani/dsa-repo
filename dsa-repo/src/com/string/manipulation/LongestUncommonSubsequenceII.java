package com.string.manipulation;

import java.util.Arrays;

/*
522. Longest Uncommon Subsequence II

Given an array of strings strs, return the length of the longest uncommon subsequence between them.
If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between an array of strings is a string that is a subsequence of one string but not the others.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in "aebdc" to get "abc".
Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).


Example 1:

Input: strs = ["aba","cdc","eae"]
Output: 3

Algorithm
-----------
In the last approach, we needed to compare all the given strings and compare them for the subsequence criteria.
We can save some computations if we sort the given set of strings based on their lengths initially.

In this approach, firstly we sort the given strings in decreasing order of their lengths.
Then, we start off by comparing the longest string with all the other strings.
If none of the other strings happens to be the subsequence of the longest string,
we return the length of the longest string as the result without any need of further comparisons.
If some string happens to be a subsequence of the longest string, we continue the same process by choosing
the second largest string as the first string and repeat the process, and so on.

Complexity Analysis

Time complexity : O(x*n^2). where nnn is the number of strings and x is the average length of the strings.

Space complexity : O(1). Constant space required.
 */
public class LongestUncommonSubsequenceII {

    public static void main(String[] args) {
        String[] str = new String[]{"aba","cdc","eae"};
        System.out.println(new LongestUncommonSubsequenceII().findLUSlength(str));
    }
    public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (a, b) -> b.length()-a.length());

        for(int i=0;i<strs.length;i++){
            boolean flag = true;
            for(int j=0;j<strs.length;j++){
                if(i==j)
                    continue;
                if(isSubSequence(strs[i],strs[j])){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return strs[i].length();
        }
        return -1;
    }

    private boolean isSubSequence(String x, String y){
        int j=0;
        for(int i=0;j<x.length() && i<y.length();i++){
            if(x.charAt(j)== y.charAt(i))
                j++;
        }
        return j==x.length();
    }
}
