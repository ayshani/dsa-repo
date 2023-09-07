package com.stack;

import java.util.Stack;

/*
227. Basic Calculator II

Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of
[-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7

 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
    }
    public int calculate(String s) {
        if(s== null || s.length()==0)
            return 0;

        Stack<Integer> st = new Stack<>();
        char operation = '+';
        int currentNumber =0;

        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber*10) +  (currentChar -'0');
            }

            if((!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)) || i== s.length()-1){
                if(operation == '+')
                    st.push(currentNumber);
                else if(operation == '-')
                    st.push(-currentNumber);
                else if(operation == '*')
                    st.push(st.pop() * currentNumber);
                else if(operation == '/')
                    st.push(st.pop() / currentNumber);
                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result =0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
