package com.twopointer;
/*
2730. Find the Longest Semi-Repetitive Substring

You are given a 0-indexed string s that consists of digits from 0 to 9.

A string t is called a semi-repetitive if there is at most one consecutive pair of the same digits inside t.

Return the length of the longest semi-repetitive substring inside s.

A substring is a contiguous non-empty sequence of characters within a string.



Example 1:

Input: s = "52233"
Output: 4
Explanation: The longest semi-repetitive substring is "5223", which starts at i = 0 and ends at j = 3.
Example 2:

Input: s = "5494"
Output: 4
Explanation: s is a semi-reptitive string, so the answer is 4.
Example 3:

Input: s = "1111111"
Output: 2
Explanation: The longest semi-repetitive substring is "11", which starts at i = 0 and ends at j = 1.

TC: o(n)
SC: o(1)
 */
public class FindTheLongestSemiRepetitiveSubstring {

    public static void main(String[] args) {
        System.out.println(new FindTheLongestSemiRepetitiveSubstring().longestSemiRepetitiveSubstring("52233"));
    }
    public int longestSemiRepetitiveSubstring(String s) {
        if(s.length()==1)
            return 1;
        int start =0, end =1;
        int maxLength=1;
        while(end<s.length()){
            //System.out.println(s.charAt(end));
            if(s.charAt(end-1)==s.charAt(end)){
                int j=end;
                //System.out.println("j "+j);
                while(j+1<s.length()){
                    if(s.charAt(j)!=s.charAt(j+1))
                        j++;
                    else
                        break;
                }
                //System.out.println("j --- "+j);

                maxLength = Math.max(maxLength, j-start+1);
                //System.out.println(maxLength);
                start= end;
            }
            end++;
        }

        return maxLength == 1 ? s.length() : maxLength;
    }
}
