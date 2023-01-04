package com.string.manipulation;
/*
521. Longest Uncommon Subsequence I

Given two strings a and b, return the length of the longest uncommon subsequence between a and b.
If the longest uncommon subsequence does not exist, return -1.

An uncommon subsequence between two strings is a string that is a subsequence of one but not the other.

A subsequence of a string s is a string that can be obtained after deleting any number of characters from s.

For example, "abc" is a subsequence of "aebdc" because you can delete the underlined characters in
"aebdc" to get "abc". Other subsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).


Example 1:

Input: a = "aba", b = "cdc"
Output: 3
Explanation: One longest uncommon subsequence is "aba" because "aba" is a subsequence of "aba" but not "cdc".
Note that "cdc" is also a longest uncommon subsequence.

Algorithm
------------
Simple analysis of this problem can lead to an easy solution.

These three cases are possible with string a and b:-

1. a=b. If both the strings are identical, it is obvious that no subsequence will be uncommon. Hence, return -1.

2. length(a)=length(b) and a≠b
 Example: abc and abd. In this case we can consider any string i.e. abc or abd as a required subsequence,
 as out of these two strings one string will never be a subsequence of other string.
 Hence, return length(a) or length(b).

length(a)≠length(b).
 Example abcd and abc. In this case we can consider bigger string as a required subsequence because bigger
 string can't be a subsequence of smaller string. Hence, return max(length(a),length(b)).

 TC : o(n) - length() function take o(n)
 SC : o(1)
 */
public class LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequenceI().findLUSlength("abc","abd"));
    }

    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(),b.length());
    }

}
