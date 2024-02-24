package com.backtracking;
/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

TC : o(
 */
import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        util(0,0,new StringBuilder(),n, result);
        return result;
    }

    private void util(int open, int close, StringBuilder cur, int n, List<String> result){
        if(cur.length()==2*n){
            result.add(String.valueOf(cur));
            return;
        }

        if(open<n){
            cur.append("(");
            util(open+1, close, cur, n, result);
            cur.deleteCharAt(cur.length()-1);
        }

        if(open> close){
            cur.append(")");
            util(open, close+1, cur, n, result);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
