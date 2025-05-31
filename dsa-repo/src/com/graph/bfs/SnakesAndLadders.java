package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
909. Snakes and Ladders
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style
starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations,
regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or
ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the
start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

Example 1:
Input: board = [[-1,-1,-1,-1,-1,-1],
                [-1,-1,-1,-1,-1,-1],
                [-1,-1,-1,-1,-1,-1],
                [-1,35,-1,-1,13,-1],
                [-1,-1,-1,-1,-1,-1],
                [-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.


TC : o(n*6)
SC : o(n*n)
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board));
    }
    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int n = size*size;

        int[] arr = new int[n];

        int index=0, inc =1, j=0, i = size-1;
        while(index<n){
            arr[index++] = board[i][j];
            if(inc== 1 && j==size-1){
                inc=-1;
                i--;
            } else if( inc == -1 && j==0){
                inc=1;
                i--;
            } else{
                j+=inc;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int start = arr[0]>-1 ? arr[0]-1 : 0;
        q.offer(start);
        visited[start]=true;
        int step =0;

        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-->0){
                int current = q.poll();
                if(current == size*size-1){
                    return step;
                }
                for(int next=current+1; next<= Math.min(current+6,size*size-1);next++){
                    int dest = arr[next] > -1 ? arr[next]-1 : next;
                    if(!visited[dest]){
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
