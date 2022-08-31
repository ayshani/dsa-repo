package com.graph.dfs;

import java.util.Arrays;

/*
130. Surrounded Regions

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        X X X X
        X O O X
        X X O X
        X O X X
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        X X X X
        X X X X
        X X X X
        X O X X
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.


TC : o(V+E)
SC : o(V+E)
 */
public class SurroundedRegions {
    int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(board);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
               System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        if(n==0 || m == 0)
            return;
        if(n<2 || m <2)
            return;

        for(int i=0;i<n;i++){
            dfs(board, i,0);
            dfs(board,i,m-1);
        }

        for(int i=0;i<m;i++){
            dfs(board, 0,i);
            dfs(board,n-1,i);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                if(board[i][j]=='*')
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int x, int y){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]!='O')
            return;

        board[x][y] = '*';

        for(int i=0;i<4;i++){
            int ix = x + direction[i][0], iy = y + direction[i][1];

            dfs(board,ix,iy);
        }
    }
}
