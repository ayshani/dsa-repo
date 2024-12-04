package com.twopointer;
/*
2825. Make String a Subsequence Using Cyclic Increments

You are given two 0-indexed strings str1 and str2.

In an operation, you select a set of indices in str1, and for each index i in the set, increment str1[i] to the next character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.

Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.

Note: A subsequence of a string is a new string that is formed from the original string by deleting some (possibly none) of the characters without disturbing the relative positions of the remaining characters.



Example 1:

Input: str1 = "abc", str2 = "ad"
Output: true
Explanation: Select index 2 in str1.
Increment str1[2] to become 'd'.
Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.

TC : o(m+n)
SC : o(n)
 */
public class MakeStringASubsequenceUsingCyclicIncrements {

    public static void main(String[] args) {
        System.out.println(new MakeStringASubsequenceUsingCyclicIncrements().canMakeSubsequence(
                "abc","ad"
        ));
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int str2Index = 0;
        int lengthStr1 = str1.length(), lengthStr2 = str2.length();

        // Traverse through both strings using a for loop
        for (
                int str1Index = 0;
                str1Index < lengthStr1 && str2Index < lengthStr2;
                ++str1Index
        ) {
            // Check if characters match, or if str1[str1Index] can be incremented to str2[str2Index]
            if (
                    str1.charAt(str1Index) == str2.charAt(str2Index) ||
                            (str1.charAt(str1Index) + 1 == str2.charAt(str2Index)) ||
                            (str1.charAt(str1Index) - 25 == str2.charAt(str2Index))
            ) {
                // If match found, move to next character in str2
                str2Index++;
            }
        }
        // Check if all characters in str2 were matched
        return str2Index == lengthStr2;
    }
}
