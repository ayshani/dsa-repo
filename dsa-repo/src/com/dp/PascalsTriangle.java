package com.dp;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]


TC : o(n)
SC : o(n)
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(3));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0 || i==j)
                    row.add(1);
                else{
                    row.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(row);
        }

        return list;
    }
}
