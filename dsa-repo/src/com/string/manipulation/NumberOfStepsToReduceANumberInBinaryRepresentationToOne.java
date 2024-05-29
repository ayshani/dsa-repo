package com.string.manipulation;
/*
1404. Number of Steps to Reduce a Number in Binary Representation to One

Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under
the following rules:

If the current number is even, you have to divide it by 2.

If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.



Example 1:

Input: s = "1101"
Output: 6
Explanation: "1101" corressponds to number 13 in their decimal representation.
Step 1) 13 is odd, add 1 and obtain 14.
Step 2) 14 is even, divide by 2 and obtain 7.
Step 3) 7 is odd, add 1 and obtain 8.
Step 4) 8 is even, divide by 2 and obtain 4.
Step 5) 4 is even, divide by 2 and obtain 2.
Step 6) 2 is even, divide by 2 and obtain 1.

TC : o(n)
SC: o(1)
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public static void main(String[] args) {
        System.out.println(new NumberOfStepsToReduceANumberInBinaryRepresentationToOne().numSteps(
                "1101"
        ));
    }
    public int numSteps(String s) {
        int n = s.length();
        int operations =0, carry =0;
        for(int i= n-1; i> 0; i--){
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if(digit%2==1){
                operations += 2;
                carry =1;
            } else{
                operations++;
            }
        }
        return operations + carry;
    }
}
