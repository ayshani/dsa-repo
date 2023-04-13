package com.stack;

import java.util.Stack;

/*
946. Validate Stack Sequences

Given two integer arrays pushed and popped each with distinct values,
return true if this could have been the result of a sequence of push and pop operations on an initially empty stack,
or false otherwise.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

TC: o(n)
SC: o(n)
 */
public class ValidateStackSequences {

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5}, pop = new int[]{4,5,3,2,1};
        System.out.println(new ValidateStackSequences().validateStackSequences(push,pop));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j =0;
        while(i<pushed.length){
            // until we reach to end of pushed array and
            // either stack is empty or top of stack is not equal to popped[j]
            // we push in the stack from pushed array
            while(i<pushed.length && (st.isEmpty() || st.peek()!=popped[j])){
                st.push(pushed[i++]);
            }
            // if top of stack is matched with popped[j]
            // we just pop from stack till top of stack keeps matching
            while(!st.isEmpty() && st.peek()==popped[j]){
                st.pop();
                j++;
            }
        }
        // if stack becomes empty that means its popped sequence can be achieved
        return st.isEmpty();
    }
}
