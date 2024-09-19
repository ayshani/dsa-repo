package com.dp;

import java.util.ArrayList;
import java.util.List;

/*
241. Different Ways to Add Parentheses

Given a string expression of numbers and operators, return all possible results from computing all the different
possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different
results does not exceed 104.

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2

TC : o(n * 2^n)
SC: o(n^2 * 2^n)
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2-1-1"));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] memo = new ArrayList[n][n];
        return compute(expression, memo, 0,n-1);
    }

    private List<Integer> compute(String expression, List<Integer>[][] memo, int start, int end){
        if(memo[start][end]!= null){
            return memo[start][end];
        }
        List<Integer> results = new ArrayList<>();

        // Base case: single digit
        if(start  == end){
            results.add(expression.charAt(start)-'0');
            return results;
        }

        // Base case: two-digit number
        if(end -start ==1 && Character.isDigit(expression.charAt(start))){
            int tens = expression.charAt(start) -'0';
            int ones = expression.charAt(end) - '0';
            results.add(10* tens + ones);
            return results;
        }

        // Recursive case: split the expression at each operator
        for(int i= start; i<=end; i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                continue;
            }
            List<Integer> leftResults = compute(
                    expression,
                    memo,
                    start,
                    i - 1
            );

            List<Integer> rightResults = compute(
                    expression,
                    memo,
                    i + 1,
                    end
            );

            // Combine results from left and right subexpressions
            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    switch (c) {
                        case '+':
                            results.add(leftValue + rightValue);
                            break;
                        case '-':
                            results.add(leftValue - rightValue);
                            break;
                        case '*':
                            results.add(leftValue * rightValue);
                            break;
                    }
                }
            }
        }
        // Memoize the result for this subproblem
        memo[start][end] = results;

        return results;
    }
}
