package com.string.manipulation;
/*
1957. Delete Characters to Make Fancy String

A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.



Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

TC : o(n)
SC : o(n)
 */
public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        System.out.println(new DeleteCharactersToMakeFancyString().makeFancyString("leeetcode"));
    }
    public String makeFancyString(String s) {
        // If the size of the string is less than 3, return it.
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        // Start by appending the first two characters to StringBuilder.
        sb.append(s.charAt(0)).append(s.charAt(1));

        // Iterate from the 3rd character onwards.
        for (int i = 2; i < s.length(); ++i) {
            // If the current character is not equal to the previously inserted
            // two characters, then we can add it to the StringBuilder.
            if (
                    s.charAt(i) != sb.charAt(sb.length() - 1) ||
                            s.charAt(i) != sb.charAt(sb.length() - 2)
            ) {
                sb.append(s.charAt(i));
            }
        }

        // Convert StringBuilder back to String and return.
        return sb.toString();
    }
}
