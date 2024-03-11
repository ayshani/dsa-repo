package com.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
100251. Shortest Uncommon Substring in an Array

You are given an array arr of size n consisting of non-empty strings.

Find a string array answer of size n such that:

answer[i] is the shortest substring of arr[i] that does not occur as a substring in any other string in arr.
If multiple such substrings exist, answer[i] should be the lexicographically smallest. And if no such substring
exists, answer[i] should be an empty string.
Return the array answer.



Example 1:

Input: arr = ["cab","ad","bad","c"]
Output: ["ab","","ba",""]
Explanation: We have the following:
- For the string "cab", the shortest substring that does not occur in any other string is either "ca" or "ab",
    we choose the lexicographically smaller substring, which is "ab".
- For the string "ad", there is no substring that does not occur in any other string.
- For the string "bad", the shortest substring that does not occur in any other string is "ba".
- For the string "c", there is no substring that does not occur in any other string.

 */
public class ShortestUncommonSubstringInAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestUncommonSubstringInAnArray().shortestSubstrings(
                new String[]{"cab", "ad", "bad", "c"}
        )));
    }
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] result = new String[n];
        Arrays.fill(result, "");

        Map<String, Integer> count =new HashMap<>();
        TreeSet<String>[] substringList = new TreeSet[n];
        for(int i=0;i<n;i++){
            substringList[i] = new TreeSet<>();
            util(arr[i], 0, new StringBuilder(), substringList[i], count);
            System.out.println( i + " : substringList[i] : "+ substringList[i]);
            System.out.println(count);
        }

        for(int i=0;i<n;i++){
            System.out.print("i : "+ i+" ");
            for(int j=0;j<substringList[i].size();j++){
                String sub = substringList[i].pollFirst();
                System.out.println("poll first : " + sub);
                if(count.get(sub) == 1){
                    System.out.println(sub +" count :  " + count.get(sub) );
                    result[i] = sub;
                    break;
                }
            }
        }
        return result;
    }

    private void util(String str, int start, StringBuilder cur, TreeSet<String> subsetList, Map<String, Integer> count){
        if(start>=str.length()){
            String s = String.valueOf(cur);
            subsetList.add(s);
            count.put(s, count.getOrDefault(s,0)+1);
            return;
        }
        if(cur.length() !=0 && cur.length()<=str.length()){
            String s = String.valueOf(cur);
            subsetList.add(s);
            count.put(s, count.getOrDefault(s,0)+1);
        }
        for(int i =start;i<str.length();i++){
            cur.append(str.charAt(i));
            util(str, i+1, cur, subsetList, count);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
