package com.array;

import java.util.Arrays;

/*
1706. Where Will the Ball Fall

You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom
sides.

Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right
or to the left.

A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented
in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented
in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall
of the box.

Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping
the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

Example 1:
Input: grid = [[1,1,1,-1,-1],
                [1,1,1,-1,-1],
                [-1,-1,-1,1,1],
                [1,1,1,1,-1],
                [-1,-1,-1,-1,-1]]
Output: [1,-1,-1,-1,-1]
Explanation: This example is shown in the photo.
Ball b0 is dropped at column 0 and falls out of the box at column 1.
Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.

Complexity Analysis
Let M be the number of rows and N be the number of columns in the grid.

Time Complexity: \O(M⋅N) In the nested for loop, the outer loop iterates N times for each column and inner
            loop iterates M times for every row in that column.

Thus, the time complexity is O(M⋅N).

Space Complexity: O(1) The algorithm uses constant extra space.

 */
public class WhereWillTheBallFall {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}
        };

        int[] res = new WhereWillTheBallFall().findBall(grid);
        Arrays.stream(res).forEach(value -> System.out.print(value +" "));
    }
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[n];

        for(int col =0; col<n;col++){
            int currentCol = col;
            for(int row =0;row<m;row++){
                int nextColumn = currentCol + grid[row][currentCol];
                if(nextColumn < 0|| nextColumn > n-1 || grid[row][currentCol] != grid[row][nextColumn]){
                    result[col] = -1;
                    break;
                }
                result[col] = nextColumn;
                currentCol = nextColumn;
            }
        }

        return result;
    }
}
