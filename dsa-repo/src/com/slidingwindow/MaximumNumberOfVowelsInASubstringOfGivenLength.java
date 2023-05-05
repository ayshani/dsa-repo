package com.slidingwindow;
/*
1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

TC: o(n)
SC: o(1)
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfVowelsInASubstringOfGivenLength().maxVowels("abciiidef",3));
    }
    public int maxVowels(String s, int k) {
        int start =0, end =0, max =0, count =0;

        while(end<s.length()){
            char cur = s.charAt(end);
            if(cur=='a'|| cur=='e'|| cur=='i' || cur=='o' || cur=='u'){
                count++;
            }
            if(end-start+1>k){
                char startChar = s.charAt(start);
                if(startChar=='a'|| startChar=='e'|| startChar=='i' || startChar=='o' || startChar=='u'){
                    count--;

                }
                start++;
            }
            end++;
            if(count==k)
                return count;
            max = Math.max(max, count);
        }
        return max;
    }
}
