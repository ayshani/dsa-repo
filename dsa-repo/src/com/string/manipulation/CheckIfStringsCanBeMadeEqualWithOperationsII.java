package com.string.manipulation;

import java.util.Arrays;

/*
2840. Check if Strings Can be Made Equal With Operations II

You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.

You can apply the following operation on any of the two strings any number of times:

Choose any two indices i and j such that i < j and the difference j - i is even, then swap the two characters at those indices in the string.
Return true if you can make the strings s1 and s2 equal, and false otherwise.



Example 1:

Input: s1 = "abcdba", s2 = "cabdab"
Output: true
Explanation: We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.

TC : o(n)
SC: o(k)
 */
public class CheckIfStringsCanBeMadeEqualWithOperationsII {

    public static void main(String[] args) {
        System.out.println(new CheckIfStringsCanBeMadeEqualWithOperationsII().checkStrings("abcdba","cabdab"));
    }
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for(int i=0;i<s1.length();i++){
            int offset = (i&1)<<7;
            count1[offset + s1.charAt(i)]++;
            count2[offset + s2.charAt(i)]++;
        }

        return Arrays.equals(count1, count2);
    }

}
