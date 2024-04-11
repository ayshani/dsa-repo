package com.stack;

import java.util.Stack;

/*
402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"

Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Logic
--------
1. Deleting k digits means keeping n - k digits, where n is the total number of digits.

2. Use a stack that you keep sorted ascendingly. You remove elements from it as long as you can
still make it to n - k digits, and your current element is smaller than the top of the stack:

push(2) => 2
push(4) because 2 < 4 => 24
push(6) because 4 < 6 => 246
pop() because 3 < 6 and we can still end up with 2 digits => 24
pop() for the same reason => 2
push(3) => 23
push(5) => 235
Then just take the first k digits => 23. Or you can make sure never to push more than k digits,
and then the final stack is your solution.

3. Note that you cannot pop elements if that means you will not be able to build a solution of k digits.
For this, you need to check the current number of elements in the stack and the number of digits to the right
of your current position on the input number.

TC : o(n)
SC : o(k)
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("10200", 1));
    }
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(k==num.length())
            return "0";
        for(int i=0;i<num.length();i++){
            while(k>0 && !st.isEmpty() && st.peek()> num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder res= new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();

        while(res.length()>1 && res.charAt(0)=='0' )
            res.deleteCharAt(0);

        return res.toString();
    }
}
