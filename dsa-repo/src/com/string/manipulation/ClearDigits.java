package com.string.manipulation;
/*
3174. Clear Digits

You are given a string s.

Your task is to remove all digits by doing this operation repeatedly:

Delete the first digit and the closest non-digit character to its left.
Return the resulting string after removing all digits.



Example 1:

Input: s = "abc"

Output: "abc"

Explanation:

There is no digit in the string.

TC : o(n)
SC: o(n)
 */
public class ClearDigits {

    public static void main(String[] args) {
        System.out.println(new ClearDigits().clearDigits("abc"));
    }
    public String clearDigits(String s) {
        StringBuilder answer = new StringBuilder();

        // Iterate over each character in the input string
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            // If the current character is a digit
            if (
                    Character.isDigit(s.charAt(charIndex)) && answer.length() != 0
            ) {
                // If the answer string is not empty, remove the last character
                answer.setLength(answer.length() - 1);
            } else {
                // If the character is not a digit, add it to the answer
                answer.append(s.charAt(charIndex));
            }
        }

        return answer.toString();
    }
}
