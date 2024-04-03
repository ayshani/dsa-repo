package com.graph.dfs;
/*
79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]],
                word = "ABCCED"
Output: true

TC : O(M*N)
SC : O(M*N)
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(new WordSearch().exist(board,"ABCCED"));

    }
    boolean ans;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(board,i,j,m,n,word,0,visited);
                    if(ans)
                        return ans;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, int i, int j, int m, int n, String word,int index, boolean[][] visited){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || word.charAt(index)!=board[i][j])
            return;
        if(index== word.length()-1)
        {
            ans = true;
            return;
        }
        visited[i][j] = true;
        dfs(board,i+1,j,m,n,word,index+1,visited);
        dfs(board,i-1,j,m,n,word,index+1,visited);
        dfs(board,i,j-1,m,n,word,index+1,visited);
        dfs(board,i,j+1,m,n,word,index+1,visited);
        visited[i][j] = false;
    }
}
