package com.string.manipulation;
/*
2287. Rearrange Characters to Make Target String

You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form
new strings.

Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.



Example 1:

Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation:
For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
We can make at most two copies of "code", so we return 2.


TC : o(n)
SC: o(1)
 */
public class RearrangeCharactersToMakeTargetString {

    public static void main(String[] args) {
        System.out.println(new RearrangeCharactersToMakeTargetString()
                .rearrangeCharacters("ilovecodingonleetcode","code"));
    }
    public int rearrangeCharacters(String s, String target) {
        int[] pattern = new int[26];
        int[] string = new int[26];
        for(int i=0;i<target.length();i++){
            pattern[target.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            string[s.charAt(i)-'a']++;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(pattern[i]!=0)
                min = Math.min(min, string[i]/ pattern[i]);
        }

        return min;

    }
}
