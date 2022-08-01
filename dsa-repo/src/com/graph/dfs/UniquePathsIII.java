package com.graph.dfs;
/*
980. Unique Paths III

You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square,
that walk over every non-obstacle square exactly once.

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths:
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)


Logic
-------
take the total empty cell count
take cell with 1 value as start index.
run dfs with four up, down left right direction .
    handle out of bound conditions.
    once u reach a cell == 2
        that means u reach ur destination chell. so check if you have covered all empty cells on the path.
            if yes -> increation result and resturn
    decrement empty cells and markt he visited cell which will fall under out of bound condition.
    once u visit all the four directions, restor eit to its original value i.e. 0.

TC : o(3^(m*n))
SC : o(m*n)
 */
public class UniquePathsIII {
    int empty =1,res=0;
    public static void main(String[] args) {
        int[][]  grid = new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        System.out.println(new UniquePathsIII().uniquePathsIII(grid));
    }

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx=-1, sy=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                    empty++;
                else if(grid[i][j]==1){
                    sx= i;
                    sy =j;
                }
            }
        }

        dfs(grid,sx,sy,m,n);
        return res;
    }

    void dfs(int[][] grid, int sx, int sy, int m , int n){
        if(sx<0 || sx >=m || sy<0 || sy>=n || grid[sx][sy]<0)
            return ;

        if(grid[sx][sy]==2)
        {
            if(empty==0)
                res++;
            return;
        }

        empty--;
        grid[sx][sy]=-2;
        dfs(grid,sx+1,sy,m,n);
        dfs(grid,sx-1,sy,m,n);
        dfs(grid,sx,sy+1,m,n);
        dfs(grid,sx,sy-1,m,n);
        empty++;
        grid[sx][sy]=0;
    }

}
