package com.map;

import java.util.HashMap;
import java.util.Map;

/*
3000. Maximum Area of Longest Diagonal Rectangle

You are given a 2D 0-indexed integer array dimensions.

For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.

Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.



Example 1:

Input: dimensions = [[9,3],[8,6]]
Output: 48
Explanation:
For index = 0, length = 9 and width = 3. Diagonal length = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487.
For index = 1, length = 8 and width = 6. Diagonal length = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10.
So, the rectangle at index 1 has a greater diagonal length therefore we return area = 8 * 6 = 48.

TC : o(n)
SC: o(n)
 */
public class MaximumAreaOfLongestDiagonalRectangle {

    public static void main(String[] args) {
        System.out.println(new MaximumAreaOfLongestDiagonalRectangle().areaOfMaxDiagonal(
                new int[][]{
                        {9,3},
                        {8,6}
                }
        ));
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double diagonal =0.0;
        Map<Double, Integer> map = new HashMap<>();
        for(int[] dimension : dimensions) {
            double diag = Math.sqrt((dimension[0] * dimension[0])  + (dimension[1] * dimension[1]));
            int ar  = dimension[0] * dimension[1];
            map.put(diag, Math.max(map.getOrDefault(diag,0), ar));
            if(diag >= diagonal){
                diagonal = diag;
            }
            //System.out.println(dimension[0] +" "+ dimension[1] +" "+ diagonal +" "+ar +" "+ area);
        }
        return map.get(diagonal);
    }
}
