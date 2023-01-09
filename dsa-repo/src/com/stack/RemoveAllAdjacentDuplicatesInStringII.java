package com.stack;

import java.util.Stack;

/*
1209. Remove All Adjacent Duplicates in String II

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and
equal letters from s and removing them, causing the left and the right side of the deleted substring
to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

TC : o(n)
SC : o(n)
 */
public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInStringII().removeDuplicates("abbbbaaacccccaaaaa",5));
    }
    public String removeDuplicates(String s, int k) {
        Stack<CharCounter> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c == stack.peek().c) {
                if (stack.peek().count == k - 1) {
                    stack.pop();
                } else {
                    stack.peek().count++;
                }
            } else {
                stack.push(new CharCounter(c));
            }
        }
        StringBuilder res = new StringBuilder();
        for (CharCounter charCount : stack) {
            res.append(charCount);
        }
        return res.toString();
    }

}

class CharCounter {
    char c;
    int count;

    CharCounter(char c) {
        this.c = c;
        this.count = 1;
    }

    @Override
    public String toString() {
        return Character.toString(c).repeat(count);
    }
}
