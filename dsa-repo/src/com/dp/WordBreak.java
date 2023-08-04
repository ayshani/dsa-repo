package com.dp;

import com.string.manipulation.WordPattern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated
sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

TC : o(n^2)
SC: o(n)
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple","pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
