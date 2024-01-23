package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1239. Maximum Length of a Concatenated String with Unique Characters

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that
has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without
changing the order of the remaining elements.

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.

TC : o(n^2)
SC : o(1)
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    int max =0;

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("cha","r","act","ers");
        System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().maxLength(lst));
    }
    public int maxLength(List<String> arr) {
        backtrack(0,arr,"");
        return max;
    }

    private void backtrack(int start, List<String> arr, String current){
        if(max<current.length()){
            max = current.length();
        }
        for(int i=start;i<arr.size();i++){
            if(!isValid(current, arr.get(i)))
                continue;
            backtrack(i+1,arr,current+arr.get(i));
        }
    }

    private boolean isValid(String current, String future){
        int[] ch = new int[26];
        for(int i=0;i<future.length();i++){
            if(++ch[future.charAt(i)-'a']==2 || current.contains(future.charAt(i)+""))
                return false;
        }
        return true;
    }
}
