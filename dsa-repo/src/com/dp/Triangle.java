package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

TC : o(n^2)
SC: o(n^2)
 */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),Arrays.asList(3,4) , Arrays.asList(6,5,7));
        System.out.println(new Triangle().minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> dp = new HashMap<>();
        return util(triangle, 0,0, dp);
    }

    private int util(List<List<Integer>> triangle, int row, int col, Map<String, Integer> dp) {
        String key = row+":"+col;
        if(dp.containsKey(key))
            return dp.get(key);
        int path = triangle.get(row).get(col);
        if(row< triangle.size()-1){
            path += Math.min(util(triangle, row+1, col, dp), util(triangle, row+1, col+1, dp));
        }
        dp.put(key, path);
        return path;
    }
}
