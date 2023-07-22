package com.dp;
/*
688. Knight Probability in Chessboard

On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves.
The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal
direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random
(even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.



Example 1:

Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.


Explanation
-------------
solution uses O(k*n^2) space for simplicity:
At every k and position i j we store the probability that the knight landed at position i j at step k.
We know that this probability is the sum of probabilities of the 8 directions in the previous step k-1 because
in the previous step all 8 of those knight's have a chance of moving here. For example since one of the
directions is 2, 1 we take the current i-2 and j-1 and add that probability/8.0 (because if the knight is
currently at i-2, j-1 the chance is only /8.0 that he'll choose this direction out of his 7 other choices).
We initialize the r , c index of the k==0 board to 1, because at step 0, we already have the knight at
position r, c so the chance it lands there in 0 steps is 100%.
The result is the sum of probabilities in all areas of the board in the Kth index Board.

SC : o(k*n^2)
 */
public class KnightProbabilityInChessboard {

    int[][] direction = new int[][]{
            {1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}
    };

    public static void main(String[] args) {
        System.out.println(new KnightProbabilityInChessboard().knightProbability(3,2,0,0));
    }
    public double knightProbability(int n, int K, int row, int column) {
        double[][][] ways = new double[K+1][n][n];
        ways[0][row][column] = 1;
        double res =0;
        for(int k=1;k<=K;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int[] d : direction){
                        int oldRow = i- d[0];
                        int oldCol = j- d[1];
                        if(oldRow>=0 && oldRow<n && oldCol>=0 && oldCol<n){
                            ways[k][i][j] += (ways[k-1][oldRow][oldCol]/8.0);

                        }
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res+= ways[K][j][i];
            }
        }
        return res;
    }
}
