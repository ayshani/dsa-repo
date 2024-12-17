package com.greedy;
/*
2182. Construct String With Repeat Limit

You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters
of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a
has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length,
b.length) characters do not differ, then the longer string is the lexicographically larger one.



Example 1:

Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all of the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a
row, so it is not a valid repeatLimitedString.

TC : o(nk)
SC: o(k)
 */
public class ConstructStringWithRepeatLimit {

    public static void main(String[] args) {
        System.out.println(new ConstructStringWithRepeatLimit().repeatLimitedString(
                "cczazcc" , 3
        ));
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int curIndex = 25;
        while(curIndex >=0){
            if(freq[curIndex] == 0){
                curIndex--;
                continue;
            }

            int use = Math.min(freq[curIndex], repeatLimit);
            for(int k=0;k<use;k++){
                sb.append((char) ('a'+curIndex));
            }

            freq[curIndex] -= use;

            if(freq[curIndex] >0){
                int smallerCharIndex  = curIndex -1;
                while(smallerCharIndex >=0 && freq[smallerCharIndex] == 0){
                    smallerCharIndex--;
                }
                if(smallerCharIndex<0){
                    break;
                }
                sb.append((char) ('a'+ smallerCharIndex));
                freq[smallerCharIndex]--;
            }
        }
        return sb.toString();
    }
}
