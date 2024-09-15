package com.bit.manipulation;
/*
1371. Find the Longest Substring Containing Vowels in Even Counts

Given the string s, return the size of the longest substring containing each vowel an even number of times.
That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.



Example 1:

Input: s = "eleetminicoworoep"
Output: 13
Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of
the vowels: a and u.

TC : o(n)
SC : o(1)
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public static void main(String[] args) {
        System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts().findTheLongestSubstring(
                "eleetminicoworoep"
        ));
    }
    public int findTheLongestSubstring(String s) {
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++)
            mp[i] = -1;

        int prefixXOR = 0, longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            System.out.println("s.charAt(i) : "+ s.charAt(i) +" prefixXOR : "+ prefixXOR);
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
            System.out.println("mp[prefixXOR] : "+ mp[prefixXOR] +" longestSubstring : "+ longestSubstring);
        }
        return longestSubstring;
    }
}
