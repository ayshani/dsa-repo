package com.stack;

import java.util.Stack;

/*
2696. Minimum String Length After Removing Substrings

You are given a string s consisting only of uppercase English letters.

You can apply some operations to this string where, in one operation, you can remove any occurrence of one of
the substrings "AB" or "CD" from s.

Return the minimum possible length of the resulting string that you can obtain.

Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.



Example 1:

Input: s = "ABFCACDB"
Output: 2
Explanation: We can do the following operations:
- Remove the substring "ABFCACDB", so s = "FCACDB".
- Remove the substring "FCACDB", so s = "FCAB".
- Remove the substring "FCAB", so s = "FC".
So the resulting length of the string is 2.
It can be shown that it is the minimum length that we can obtain.

TC : o(n)
SC: o(n)
 */
public class MinimumStringLengthAfterRemovingSubstrings {

    public static void main(String[] args) {
        System.out.println(new MinimumStringLengthAfterRemovingSubstrings().minLength("ABFCACDB"));
    }
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the stack is empty, simply push the current character
            if (stack.isEmpty()) {
                stack.push(currentChar);
                continue;
            }

            // Check for "AB" pattern, remove the pair by popping from the stack
            if (currentChar == 'B' && stack.peek() == 'A') {
                stack.pop();
            }
            // Check for "CD" pattern, remove the pair by popping from the stack
            else if (currentChar == 'D' && stack.peek() == 'C') {
                stack.pop();
            }
            // Otherwise, push the current character onto the stack
            else {
                stack.push(currentChar);
            }
        }

        return stack.size();
    }
}
