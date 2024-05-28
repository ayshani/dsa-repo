package com.slidingwindow;
/*
1208. Get Equal Substrings Within Budget

You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]|
(i.e., the absolute difference between the ASCII values of the characters).

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of
t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its
corresponding substring from t, return 0.



Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd".
That costs 3, so the maximum length is 3.

TC : o(n)
SC: o(1)
 */
public class GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd","bcdf",3));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxLen =0, start =0, curCost =0;
        for(int end =0; end<n;end++){
            curCost += Math.abs(s.charAt(end) - t.charAt(end));
            while(curCost > maxCost){
                curCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end - start+1);
        }
        return maxLen;
    }
}
