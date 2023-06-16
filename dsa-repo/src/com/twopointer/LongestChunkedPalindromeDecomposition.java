package com.twopointer;
/*
1147. Longest Chunked Palindrome Decomposition

You are given a string text. You should split it to k substrings (subtext1, subtext2, ..., subtextk) such that:

subtexti is a non-empty string.
The concatenation of all the substrings is equal to text (i.e., subtext1 + subtext2 + ... + subtextk == text).
subtexti == subtextk - i + 1 for all valid values of i (i.e., 1 <= i <= k).
Return the largest possible value of k.



Example 1:

Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".

TC : o(n)
SC: o(1)
 */
public class LongestChunkedPalindromeDecomposition {

    public static void main(String[] args) {
        System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));

    }
    public int longestDecomposition(String text) {
        String l ="", r = "";
        int k=0, n = text.length();
        for(int i=0;i<n;i++){
            l  = l+ text.charAt(i);
            r = text.charAt(n-1-i)+r;

            if(l.equals(r)){
                k++;
                l = "";
                r ="";
            }
        }
        return k;
    }
}
