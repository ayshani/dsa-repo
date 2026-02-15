package com.string.manipulation;
/*
67. Add Binary

Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"

TC : o(n)
SC: o(1)
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11","1"));
    }
    public String addBinary(String a, String b) {
        int sum =0, carry =0, i= a.length()-1, j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            sum= carry;
            if(i>=0){
                sum+= a.charAt(i) -'0';
            }
            if(j>=0){
                sum+= b.charAt(j) -'0';
            }

            sb.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }

        if(carry!=0)
            sb.append(carry);

        return sb.reverse().toString();

    }
}
