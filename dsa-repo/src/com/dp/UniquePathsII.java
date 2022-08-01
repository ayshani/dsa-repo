package com.dp;
/*
63. Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner
(i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid.
A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

TC : o(m*n)
SC ; o(m*n)
 */
public class UniquePathsII {

    int count =0;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(grid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m  = obstacleGrid.length;
        int n  = obstacleGrid[0].length;

        if(!isValid(obstacleGrid,0,0) || !isValid(obstacleGrid,m-1,n-1))
            return 0;

        obstacleGrid[0][0] = 1;

        for(int i=1;i<m;i++){
            obstacleGrid[i][0] = !isValid(obstacleGrid,i,0)?0:obstacleGrid[i-1][0];
        }

        for(int i=1;i<n;i++){
            obstacleGrid[0][i] = !isValid(obstacleGrid,0,i)?0:obstacleGrid[0][i-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                obstacleGrid[i][j] = !isValid(obstacleGrid,i,j)?0:obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }


        return obstacleGrid[m-1][n-1];
    }


    boolean isValid(int[][] obs,int x,int y){
        if(obs[x][y]==0)
            return true;
        return false;
    }
}
