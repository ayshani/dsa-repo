package com.string.manipulation;
/*
856. Score of Parentheses

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:

Input: s = "()"
Output: 1

TC : o(n)
SC : o(1)
 */
public class ScoreOfParentheses {

    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("()"));
    }
    public int scoreOfParentheses(String s) {
        int score =0, depth =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
            } else{
                depth--;
                if(s.charAt(i-1)=='('){
                    score +=(1<<depth);
                }
            }
        }
        return score;
    }
}
