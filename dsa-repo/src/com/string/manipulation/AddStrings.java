package com.string.manipulation;
/*
415. Add Strings

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

TC : o(n)
SC: o(1)
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("11","12"));
    }
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1;
        int carry =0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int intNum1=0,intNum2=0;
            if(i>=0){
                intNum1 = Character.getNumericValue(num1.charAt(i));
                i--;
            }
            if(j>=0){
                intNum2 = Character.getNumericValue(num2.charAt(j));
                j--;
            }

            int sum = intNum1 + intNum2 + carry;
            carry = sum/10;
            sum %= 10;
            sb.insert(0,String.valueOf(sum));

        }
        if(carry>0){
            sb.insert(0,String.valueOf(carry));
        }
        return sb.toString();
    }
}
