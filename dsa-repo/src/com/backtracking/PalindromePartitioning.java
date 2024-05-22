package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
131. Palindrome Partitioning

Given a string s, partition s such that every
substring of the partition is palindrom. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Algorithm
--------------
In the backtracking algorithm, we recursively traverse over the string in depth-first search fashion.
For each recursive call, the beginning index of the string is given as start.

Iteratively generate all possible substrings beginning at index start. The index end increments from
start until the end of the string.

For each of the substrings generated, check if it is a palindrome.

If the substring is a palindrome, the substring is a potential candidate. Add the substring to the
currentList and perform a depth-first search on the remaining substring.
If the current substring ends at index end, end+1 becomes the start index for the next recursive call.

Backtrack if start index is greater than or equal to the string length and add the
currentList to the result.

Complexity Analysis

Time Complexity : O(N⋅2^N), where N is the length of string s.
This is the worst-case time complexity when all the possible substrings are palindrome.

Hence, there could be 2^N possible substrings in the worst case.
For each substring, it takes O(N) time to generate the substring and determine if it is a palindrome or not.
This gives us a time complexity of O(N⋅2^N)

Space Complexity: O(N), where N is the length of the string s.
This space will be used to store the recursion stack. For s = aaa,
the maximum depth of the recursive call stack is 3 which is equivalent to N.
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0,new ArrayList<String>(), result);
        return result;
    }

    private void dfs(String s, int start, List<String>  currentList, List<List<String>> result) {
        if(start>= s.length()){
            result.add(new ArrayList<>(currentList));
            return ;
        }
        for(int end = start; end< s.length();end++){
            if(isPalindrome(s, start,end)){
                currentList.add(s.substring(start,end+1));
                dfs(s,end+1, currentList,result);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!= s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
