package com.array;

import java.util.Arrays;

/*
3335. Total Characters in String After Transformations I

You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:

If the character is 'z', replace it with the string "ab".
Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
Return the length of the resulting string after exactly t transformations.

Since the answer may be very large, return it modulo 109 + 7.

Example 1:

Input: s = "abcyy", t = 2

Output: 7

Explanation:

First Transformation (t = 1):
'a' becomes 'b'
'b' becomes 'c'
'c' becomes 'd'
'y' becomes 'z'
'y' becomes 'z'
String after the first transformation: "bcdzz"
Second Transformation (t = 2):
'b' becomes 'c'
'c' becomes 'd'
'd' becomes 'e'
'z' becomes "ab"
'z' becomes "ab"
String after the second transformation: "cdeabab"
Final Length of the string: The string is "cdeabab", which has 7 characters.

TC : o(n + z)
SC: o(z)
 */
public class TotalCharactersInStringAfterTransformationsI {

    public static void main(String[] args) {
        System.out.println(new TotalCharactersInStringAfterTransformationsI().lengthAfterTransformations(
                "abcyy", 2
        ));
    }
    private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for(char ch: s.toCharArray()){
            ++cnt[ch-'a'];
        }
        System.out.println(Arrays.toString(cnt));
        for(int round =0; round<t;round++){
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25]+cnt[0])%MOD;
            for(int i=2;i<26;i++){
                nxt[i] = cnt[i-1];
            }
            cnt = nxt;
            System.out.println(Arrays.toString(cnt));
        }


        int ans =0;
        for(int i=0;i<26;i++){
            ans = (ans+cnt[i])%MOD;
        }
        return ans;
    }
}
