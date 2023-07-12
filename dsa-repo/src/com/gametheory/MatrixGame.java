package com.gametheory;
/*
Matrix Game

Two players A and B play the following game.

1) First, a matrix mat of size n*m is chosen, and filled with non-zero numbers.

2) Player A starts the game and the players play alternately.

3) In his turn, a player chooses any row which has atleast one non-zero number in it. In this row, the leftmost
non-zero number is chosen. Let this number be K. The player subtracts any number between 1 and K inclusive from it.

4) The game ends when all the numbers in the matrix M are 0.

5) The player who plays last wins the game.

Given n,m, and the initial matrix, determine who wins the game. Assume that both players play optimally.

Return "First" if A is the winner or "Second" if B is the winner without quotes.

Constraints:

1<= n,m <= 1000

1<= mat[i][j] <= 1000



Example:

Input

n = 2, m = 2
mat = [
    [3, 2],
    [3, 2],
]
Output

Second

TC : o(n)
SC: o(1)
 */
public class MatrixGame {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{4,3,2,3},{4,2,3,5}};
        System.out.println(new MatrixGame().solve(2,4,mat));
    }
    String  solve(int n,int m, int[][] mat){
        int x=0;
        for(int i=0;i<n;i++)
        {
            int ans=0;
            for(int j=m-1;j>=0;j--)
            {
                if(mat[i][j]<=ans)
                    ans=mat[i][j]-1;
                else
                    ans=mat[i][j];
            }
            x^=ans;
        }
        if(x!=0)
        {
            return "First";
        }
        else{
            return "Second";
        }
    }
}
