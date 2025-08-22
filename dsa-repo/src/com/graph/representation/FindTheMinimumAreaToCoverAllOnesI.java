package com.graph.representation;
/*
3195. Find the Minimum Area to Cover All Ones I

You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.



Example 1:

Input: grid = [[0,1,0],[1,0,1]]

Output: 6

Explanation:
The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.
 */
public class FindTheMinimumAreaToCoverAllOnesI {

    public static void main(String[] args) {
        System.out.println(new FindTheMinimumAreaToCoverAllOnesI().minimumArea(
                new int[][]{
                        {0,1,0},
                        {1,0,1}
                }
        ));
    }
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minLeft = n, maxRight = -1, minTop = m, maxBottom = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && minLeft>j){
                    minLeft = j;
                    minTop = Math.min(minTop, i);
                }
                if(grid[i][j]==1 ){
                    if(maxRight<=j)
                        maxRight = j;
                    maxBottom = Math.max(maxBottom, i);
                }
            }
        }
        //System.out.println(minLeft +" "+ maxRight +" "+minTop +" "+ maxBottom);
        if(minLeft == n || maxRight == -1 ||  minTop == m || maxBottom == -1){
            return 0;
        }

        return (maxBottom - minTop+1)*(maxRight - minLeft+1);

    }
}
