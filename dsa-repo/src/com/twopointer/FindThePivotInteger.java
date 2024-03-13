package com.twopointer;
/*
2485. Find the Pivot Integer

Given a positive integer n, find the pivot integer x such that:

The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most
one pivot index for the given input.

Example 1:

Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.

TC : o(n)
SC: o(1)
 */
public class FindThePivotInteger {
    public static void main(String[] args) {
        System.out.println(new FindThePivotInteger().pivotInteger(8));
    }
    public int pivotInteger(int n) {
        if(n<=1)
            return n;

        int forwardSum =1, backwardSum =n;
        int i=1, j= n;
        while(i<j){
            if(forwardSum<backwardSum){
                forwardSum += ++i;
            }else{
                backwardSum += --j;
            }
            if(forwardSum==backwardSum && i+1==j-1){
                return i+1;
            }
        }
        return -1;
    }
}
