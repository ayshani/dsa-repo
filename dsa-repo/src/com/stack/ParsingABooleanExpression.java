package com.stack;

import java.util.ArrayList;
import java.util.Stack;

/*
1106. Parsing A Boolean Expression

A boolean expression is an expression that evaluates to either true or false. It can be in one of the following
shapes:

't' that evaluates to true.
'f' that evaluates to false.
'!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
'&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1,
subExpr2, ..., subExprn where n >= 1.
'|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1,
subExpr2, ..., subExprn where n >= 1.
Given a string expression that represents a boolean expression, return the evaluation of that expression.

It is guaranteed that the given expression is valid and follows the given rules.



Example 1:

Input: expression = "&(|(f))"
Output: false
Explanation:
First, evaluate |(f) --> f. The expression is now "&(f)".
Then, evaluate &(f) --> f. The expression is now "f".
Finally, return false.

TC : o(n)
SC: o(n)
 */
public class ParsingABooleanExpression {

    public static void main(String[] args) {
        System.out.println(new ParsingABooleanExpression().parseBoolExpr("&(|(f))"));
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        // Traverse the entire expression
        for (char currChar : expression.toCharArray()) {
            if (currChar == ')') {
                ArrayList<Character> values = new ArrayList<>();

                // Gather all values inside the parentheses
                while (st.peek() != '(') {
                    values.add(st.pop());
                }
                st.pop(); // Remove '('
                char op = st.pop(); // Remove the operator
                // Evaluate the subexpression and push the result back
                char result = evaluateSubExpr(op, values);
                st.push(result);
            } else if (currChar != ',') {
                st.push(currChar); // Push non-comma characters into the stack
            }
        }

        // Final result is on the top of the stack
        return st.peek() == 't';

    }

    // Evaluates a subexpression based on the operator and list of values
    private char evaluateSubExpr(char op, ArrayList<Character> values) {
        if (op == '!') return values.get(0) == 't' ? 'f' : 't';

        // AND: return 'f' if any value is 'f', otherwise return 't'
        if (op == '&') {
            for (char value : values) {
                if (value == 'f') return 'f';
            }
            return 't';
        }

        // OR: return 't' if any value is 't', otherwise return 'f'
        if (op == '|') {
            for (char value : values) {
                if (value == 't') return 't';
            }
            return 'f';
        }

        return 'f'; // This point should never be reached
    }
}
