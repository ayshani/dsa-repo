package com.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
989. Add to Array-Form of Integer

The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.



Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

TC : o(n)
SC: o(1)
 */
public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(new int[]{1,2,0,0}, 34));
    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int cur =k, n = num.length;
        int i= n;
        while(--i>=0 || cur>0){
            if(i>=0)
                cur+= num[i];
            res.add(cur%10);
            cur = cur/10;
        }

        Collections.reverse(res);
        return res;
    }
}
