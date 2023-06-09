package com.twopointer;
/*
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

TC : o(n)
SC: o(1)
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("sadbutsad","sad"));
    }
    public int strStr(String haystack, String needle) {

        int m = haystack.length(), n = needle.length();
        if(m<n)
            return -1;
        for(int i=0;i<=m-n;i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)== needle.charAt(j)){
                j++;
            }
            if(j== n)
                return i;
        }

        return  -1;
    }
}
