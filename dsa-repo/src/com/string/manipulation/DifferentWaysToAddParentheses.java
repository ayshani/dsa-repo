package com.string.manipulation;

import java.util.LinkedList;
import java.util.List;

/*
241. Different Ways to Add Parentheses

Given a string expression of numbers and operators, return all possible results from computing all the different
possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results
does not exceed 104.

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2

TC : catalan number tc

 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new LinkedList<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                String part1 = expression.substring(0,i);
                String part2 = expression.substring(i+1);
                List<Integer> resultPart1 = diffWaysToCompute(part1);
                List<Integer> resultPart2 = diffWaysToCompute(part2);
                for(Integer p1 : resultPart1){
                    for(Integer p2 : resultPart2){
                        int c =0;
                        switch(expression.charAt(i)){
                            case '+' :
                                c = p1+p2;
                                break;
                            case '-' :
                                c = p1-p2;
                                break;
                            case '*' :
                                c = p1*p2;
                                break;
                        }
                        result.add(c);
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}
