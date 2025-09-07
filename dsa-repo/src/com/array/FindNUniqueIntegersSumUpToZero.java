package com.array;

import java.util.Arrays;

/*
1304. Find N Unique Integers Sum up to Zero

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

TC : o(n)
SC: o(1)
 */
public class FindNUniqueIntegersSumUpToZero {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindNUniqueIntegersSumUpToZero().sumZero(5)));
    }
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index =0;
        for(int i=1;i<=n/2;i++){
            ans[index++] = i;
            ans[index++] = -i;
        }
        if(n%2 == 1){
            ans[index] = 0;
        }
        return ans;
    }
}
