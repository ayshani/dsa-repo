package com.string.manipulation;
/*
1653. Minimum Deletions to Make String Balanced

You are given a string s consisting only of characters 'a' and 'b'.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices
(i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.



Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").

TC : o(n)
SC: o(n)
 */
public class MinimumDeletionsToMakeStringBalanced {

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeStringBalanced().minimumDeletions("aababbab"));
    }
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int aCount =0;
        for(int i=n-1;i>=0;i--){
            countA[i] = aCount;
            if(s.charAt(i)=='a'){
                aCount++;
            }
        }
        int minDel = n, bCount =0;
        for(int i=0;i<n;i++){
            minDel = Math.min(minDel, countA[i] + bCount);
            if(s.charAt(i)=='b'){
                bCount++;
            }
        }
        return minDel;
    }
}
