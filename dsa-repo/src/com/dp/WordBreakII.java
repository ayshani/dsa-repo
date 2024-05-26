package com.dp;

import java.util.*;

/*
140. Word Break II

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is
a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

 */
public class WordBreakII {

    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("applepenapple", Arrays.asList("apple","applep","en","pen")));

    }
    public List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        List<String>[] dp = new ArrayList[n+1];
        List<String> initial = new ArrayList<>();
        initial.add("");
        dp[0] = initial;

        for(int i=1;i<=n;i++){
            List<String> list = new ArrayList<>();
            for(int j=0;j<i;j++){
                String word = s.substring(j,i);

                if(dp[j].size()>0 && set.contains(word)){
                    for(String str : dp[j]){
                        list.add(str + (str.equals("")? "" : " ")+ word);
                    }
                }
                //System.out.println(word +" "+ j + "-"+ i +" : "+ list);
                dp[i] = list;
            }
        }
        return dp[n];
    }
}
