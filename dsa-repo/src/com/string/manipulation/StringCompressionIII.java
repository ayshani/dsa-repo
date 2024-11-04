package com.string.manipulation;
/*
3163. String Compression III

Given a string word, compress it using the following algorithm:

Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.



Example 1:

Input: word = "abcde"

Output: "1a1b1c1d1e"

Explanation:

Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in
each operation.

For each prefix, append "1" followed by the character to comp.

TC : o(n)
SC: o(n)
 */
public class StringCompressionIII {

    public static void main(String[] args) {
        System.out.println(new StringCompressionIII().compressedString("abcde"));
    }
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder("");

        // pos tracks our position in the input string
        int pos = 0;

        // Process until we reach end of string
        while (pos < word.length()) {
            int consecutiveCount = 0;

            char currentChar = word.charAt(pos);

            // Count consecutive occurrences (maximum 9)
            while (
                    pos < word.length() &&
                            consecutiveCount < 9 &&
                            word.charAt(pos) == currentChar
            ) {
                consecutiveCount++;
                pos++;
            }

            // Append count followed by character to result
            comp.append(consecutiveCount).append(currentChar);
        }

        return comp.toString();
    }
}
