package com.string.manipulation;
/*
3121. Count the Number of Special Characters II

You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word,
and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.



Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

TC : o(n)
SC: o(1)
 */
public class CountTheNumberOfSpecialCharactersII {

    public static void main(String[] args) {
        System.out.println(new CountTheNumberOfSpecialCharactersII().numberOfSpecialChars("aaAbcBC"));
    }
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] small = new int[26], upper = new int[26];

        int count =0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                small[ch-'a'] =1;
            } else{
                upper[ch-'A'] =1;
            }
        }
        for(int i=0;i<26;i++){
            if(small[i] == 1 && upper[i] == 1){
                int smallFirstIndex =  word.indexOf((char)('a' + i));
                int smallLastIndex =  word.lastIndexOf((char)('a' + i));
                int upperFirstIndex =  word.indexOf((char)('A' + i));
                int upperLastIndex =  word.lastIndexOf((char)('A' + i));
                if(upperFirstIndex> smallLastIndex){
                    count++;
                }
            }
        }
        return count;
    }
}
