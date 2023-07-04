package com.string.manipulation;
/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

TC : o(minLen*n)
SC: o(1)
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            minLen = Math.min(minLen, strs[i].length());
        }

        for(int i=0;i<minLen;i++){
            char cur = strs[0].charAt(i);
            boolean flag = true;
            for(int j=1;j<strs.length;j++){
                if(cur != strs[j].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            } else{
                ans += String.valueOf(cur);
            }
        }
        return ans;

    }
}
