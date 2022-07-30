package com.slidingwindow;
/*
1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are
 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

Logic
-------
have one count[] to count the occurrence of a,b,c.
update the occurrence for every iteration of character in String s.
    also squeeze the range till condition hold and add the starting index.
    for eg:

    a a a b b c c a b c
    when all a, b, c > 0 for first time at j = 5 the n after while loop i will be at i = 3,
    we will add 3 to result because there would be three substrings from three a's.

    Then a,b,c > 0 at j = 7 ,then we will move i until i = 5 then we will add 5 to result
    because there could be 5 substrings starting from 0 to second b.

    And similarly we proceed....

TC : o(n)
SC : o(1)
 */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new NumberOfSubstringsContainingAllThreeCharacters().numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int[] count =new int[]{0,0,0};

        int res =0,i=0;
        for(int j=0;j<s.length();j++) {
            count[s.charAt(j) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(i++) - 'a']--;
            }
            res += i;
        }
        return res;
    }

}
