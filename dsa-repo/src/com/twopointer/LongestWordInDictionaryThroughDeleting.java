package com.twopointer;

import java.util.*;

/*
524. Longest Word in Dictionary through Deleting

Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed
by deleting some of the given string characters. If there is more than one possible result, return the longest
word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"

Algorithm

The matching condition in the given problem requires that we need to consider the matching string in the
dictionary with the longest length and in case of same length, the string which is smallest lexicographically.
To ease the searching process, we can sort the given dictionary's strings based on the same criteria,
such that the more favorable string appears earlier in the sorted dictionary.

Now, instead of performing the deletions in s, we can directly check if any of the words given in the
dictionary(say x) is a subsequence of the given string ss, starting from the beginning of the dictionary.
This is because, if x  is a subsequence of s, we can obtain x by performing delete operations on s.

If x is a subsequence of s every character of x will be present in s.

Complexity Analysis

Time complexity : O(n⋅xlogn+n⋅x). Here n refers to the number of strings in list d and x refers to average string length.
 Sorting takes O(nlogn) and isSubsequence takes O(x) to check whether a string is a subsequence of another string or not.

Space complexity : O(logn). Sorting takes O(logn) space in average case.
 */
public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord("abpcplea",dict));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length()!=s2.length() ? s2.length()-s1.length() : s1.compareTo(s2);
            }
        });

        for(String wordInDictionary : dictionary){
            if(isSubSequence(wordInDictionary,s))
                return wordInDictionary;
        }

        return "";
    }

    private boolean isSubSequence(String wordInDictionary,String s){
        int j=0;
        for(int i=0;i<s.length() && j<wordInDictionary.length();i++){
            if(s.charAt(i)== wordInDictionary.charAt(j))
                j++;
        }

        return j==wordInDictionary.length();
    }
}
