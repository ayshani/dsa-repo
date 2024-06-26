package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
417. Pacific Atlantic Water Flow

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
The Pacific Ocean touches the island's left and top edges,
and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix
heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells
directly north, south, east, and west if the neighboring cell's height is less than or equal
to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci]
denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
pacific ocean     ________
 pa   1  2  2  3  5
 ci   3  2  3  4  4  atlan
 fi   2  4  5  3  1  tic
 c    6  7  1  4  5  ocean
 ____ 5  1  1  2  4
        atlantic ocean

Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

TC : o(m*n)
SC : o(m*n)
 */
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}
        };

        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(grid));
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(heights,pacific, Integer.MIN_VALUE, i,0);
            dfs(heights,atlantic, Integer.MIN_VALUE, i,m-1);
        }

        for(int i=0;i<m;i++){
            dfs(heights,pacific, Integer.MIN_VALUE, 0,i);
            dfs(heights,atlantic, Integer.MIN_VALUE, n-1,i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int[][] heights, boolean[][] visited, int value, int x, int y){
        int n = heights.length, m = heights[0].length;

        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || heights[x][y]<value)
            return;
        visited[x][y] = true;
        for(int[] d : dir){
            dfs(heights,visited, heights[x][y], x+d[0],y+d[1]);
        }
    }
}
