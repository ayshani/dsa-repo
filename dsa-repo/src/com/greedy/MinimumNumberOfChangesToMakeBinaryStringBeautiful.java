package com.greedy;
/*
2914. Minimum Number of Changes to Make Binary String Beautiful

You are given a 0-indexed binary string s having an even length.

A string is beautiful if it's possible to partition it into one or more substrings such that:

Each substring has an even length.
Each substring contains only 1's or only 0's.
You can change any character in s to 0 or 1.

Return the minimum number of changes required to make the string s beautiful.



Example 1:

Input: s = "1001"
Output: 2
Explanation: We change s[1] to 1 and s[3] to 0 to get string "1100".
It can be seen that the string "1100" is beautiful because we can partition it into "11|00".
It can be proven that 2 is the minimum number of changes needed to make the string beautiful.

TC : o(n)
SC: o(1)
 */
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfChangesToMakeBinaryStringBeautiful().minChanges("1001"));
    }
    public int minChanges(String s) {
        // Initialize with first character of string
        char currentChar = s.charAt(0);

        int consecutiveCount = 0;
        int minChangesRequired = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // If current character matches the previous sequence
            if (s.charAt(i) == currentChar) {
                consecutiveCount++;
                continue;
            }

            // If we have even count of characters, start new sequence
            if (consecutiveCount % 2 == 0) {
                consecutiveCount = 1;
            }
            // If odd count, we need to change current character
            // to match previous sequence
            else {
                consecutiveCount = 0;
                minChangesRequired++;
            }

            // Update current character for next iteration
            currentChar = s.charAt(i);
        }

        return minChangesRequired;
    }
}
