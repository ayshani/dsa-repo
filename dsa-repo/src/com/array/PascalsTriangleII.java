package com.array;

import java.util.Arrays;
import java.util.List;

/*
119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]

TC : o(m*n)
SC o(1)
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        int[] ar = new int[rowIndex+1];
        ar[0]=1;
        for(int i=1;i<rowIndex+1;i++){
            for(int j=i;j>=1;j--){
                ar[j]+=ar[j-1];
            }
        }
        List<Integer> list = Arrays.stream(ar).boxed().toList();
        return list;
    }
}
