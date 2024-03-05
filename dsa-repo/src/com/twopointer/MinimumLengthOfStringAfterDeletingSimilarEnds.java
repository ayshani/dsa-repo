package com.twopointer;
/*
1750. Minimum Length of String After Deleting Similar Ends

Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm
on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).



Example 1:

Input: s = "ca"
Output: 2
Explanation: You can't remove any characters, so the string stays as is.

 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        System.out.println(new MinimumLengthOfStringAfterDeletingSimilarEnds().minimumLength("cabaabac"));
    }
    public int minimumLength(String s) {
        int n = s.length();

        int i=0, j= n-1, length = n;
        while(i<j){
            char first = s.charAt(i), last = s.charAt(j);
            if(first == last){
                while(i<j && s.charAt(i)== first){
                    i++;
                }
                while(j>=0 && s.charAt(j)== last){
                    j--;
                }
                if(i==j)
                    return 1;
            } else{
                break;
            }
        }
        if(i>j)
            return 0;
        return s.substring(i,j+1).length();
    }
}
