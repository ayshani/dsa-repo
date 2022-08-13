package com.backtracking;
/*
37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]

Output:
[["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]

TC : o(9^(n*n))

 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board= new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        new SudokuSolver().solveSudoku(board);;

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }

    }
    public void solveSudoku(char[][] board) {
        if(board==null || board[0].length==0)
            return;
        solve(board);
    }
    public boolean solve(char[][] board) {
        int i=0,j=0;
        boolean flag = false;
        for(i=0;i<board.length;i++){
            for(j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    flag = true;
                    break;
                }

            }
            if(flag)
                break;
        }

        if(i==board.length && j==board[0].length)
            return true;

        for(char n='1';n<='9';n++){
            if(isSafe(board,i,j,n)){
                board[i][j] = n;
                if(solve(board))
                    return true;
                board[i][j]='.';
            }
        }

        return false;
    }


    private boolean isSafe(char[][] board, int i, int j, char n){
        for(int k=0;k<board.length;k++){
            if(board[k][j] == n || board[i][k] == n)
                return false;
        }

        int sqrt = (int)Math.sqrt(board.length);
        int istart = i-i%sqrt;
        int jStart = j -j%sqrt;

        for( i=0;i<sqrt;i++){
            for( j=0;j<sqrt;j++){
                if(board[i+istart][j+jStart] == n)
                    return false;
            }
        }

        return true;
    }
}
