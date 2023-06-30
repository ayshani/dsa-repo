package com.matrix;
/*
1275. Find Winner on a Tic Tac Toe Game

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.



Example 1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

TC : o(n*n)
 */
public class FindWinnerOnATicTacToeGame {

    int n =3;

    public static void main(String[] args) {
        int[][] moves = new int[][]{
                {0,0},{2,0},{1,1},{2,1},{2,2}
        };
        System.out.println(new FindWinnerOnATicTacToeGame().tictactoe(moves));
    }
    public String tictactoe(int[][] moves) {
        char[][] board = new char[n][n];
        for(int i=0;i<moves.length;i++){
            int row = moves[i][0];
            int col = moves[i][1];
            if((i&1)==0){
                //even, X's move
                board[row][col] = 'X';
                if(hasPlayerWon(board, row, col,'X'))
                    return "A";
            } else{
                //odd, O's move
                board[row][col] = 'O';
                if(hasPlayerWon(board, row, col,'O'))
                    return "B";
            }
        }
        return moves.length == n*n ? "Draw" : "Pending";
    }

    boolean hasPlayerWon(char[][] board, int row, int col,char currentPlayer){
        //check the current row
        boolean hasPlayerWon = true;
        for(int i=0;i<n;i++){
            if(board[row][i]!=currentPlayer){
                hasPlayerWon = false;
                break;
            }
        }
        if(hasPlayerWon)
            return true;

        //check the current rocolw
        hasPlayerWon = true;
        for(int i=0;i<n;i++){
            if(board[i][col]!=currentPlayer){
                hasPlayerWon = false;
                break;
            }
        }
        if(hasPlayerWon)
            return true;

        // check the diagonal
        if(row==col){
            hasPlayerWon = true;
            for(int i=0;i<n;i++){
                if(board[i][i] !=currentPlayer){
                    hasPlayerWon = false;
                    break;
                }
            }
            if(hasPlayerWon)
                return true;
        }

        // check reverse diagonal
        if(col == n-row-1){
            hasPlayerWon = true;
            for(int i=0;i<n;i++){
                if(board[i][n-i-1] !=currentPlayer){
                    hasPlayerWon = false;
                    break;
                }
            }
            if(hasPlayerWon)
                return true;
        }
        return false;
    }
}
