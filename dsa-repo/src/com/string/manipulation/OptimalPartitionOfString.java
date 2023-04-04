package com.string.manipulation;

import java.util.Arrays;

/*
2405. Optimal Partition of String

Given a string s, partition the string into one or more substrings such that the characters in each substring
are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.



Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.

TC : o(n)
SC: o(1)
 */
public class OptimalPartitionOfString {

    public static void main(String[] args) {
        System.out.println(new OptimalPartitionOfString().partitionString("abacaba"));
    }
    public int partitionString(String s) {
        int[] chars = new int[26];

        int uniques =1;

        for(int i=0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            if(chars[index]==0){
                chars[index]=1;
            } else{
                uniques++;
                Arrays.fill(chars,0);
                chars[index] =1;
            }
        }

        return uniques;
    }
}
