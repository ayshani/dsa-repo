package com.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
301. Remove Invalid Parentheses

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to
make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals.
You may return the answer in any order.



Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]

TC: o(2^n)
SC: o(n)
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
    }
    public List<String> removeInvalidParentheses(String s) {
        return remove(s, new HashSet<String>());
    }

    private List<String> remove(String s, Set<String> set){
        if(isValid(s)){
            List<String> maxSol = new ArrayList<>();
            maxSol.add(s);
            return maxSol;
        }

        Set<String> sol = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c==')'){
                String without =  s.substring(0,i)+ s.substring(i+1);
                if(set.add(without)){
                    sol.addAll(remove(without, set));
                }
            }
        }

        int max =0;
        for(String str : sol){
            max = Math.max(max, str.length());
        }

        List<String> maxSol = new ArrayList<>();
        for(String str : sol){
            if(str.length()== max)
                maxSol.add(str);
        }

        return maxSol;
    }

    private boolean isValid(String s){
        int open =0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                open++;
            } else if(c==')'){
                open--;
            }
            if(open<0){
                return false;
            }
        }
        return open==0;
    }
}
