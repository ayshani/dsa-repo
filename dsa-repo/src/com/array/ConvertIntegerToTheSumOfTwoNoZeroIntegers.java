package com.array;

import java.util.Arrays;

/*
1317. Convert Integer to the Sum of Two No-Zero Integers

No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.



Example 1:

Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.

TC : o(n)
SC: o(1)
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConvertIntegerToTheSumOfTwoNoZeroIntegers().getNoZeroIntegers(2)));
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int j = n-i;
            if(!String.valueOf(i).contains("0") &&
                    !String.valueOf(j).contains("0")){
                return new int[]{i,j};
            }
        }
        return new int[0];
    }
}
