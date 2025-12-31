package com.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
1970. Last Day Where You Can Still Cross

There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col
representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water.
You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell
on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells.
You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four
cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.



Example 1:
Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.


Explanation
-------------
Idea

Since each day, the new cell becomes flooded with water, so if on i th day, we can't walk from the top to bottom
then all days after i th we also can't walk.
So we can Binary Search to find the last day we can walk in range [1..len(cells)],
for each mid = (left + right)/2), we need to check if we can still walk in mid th day.
How to check if we can walk in dayAt th day?
Firstly, we build the grid in the dayAt th day
Then we use BFS to check if we can reach to the any cells in bottom row by starting from any cells in top row.

Complexity

Time: O(row*col * log(row*col)), where row * col <= 2*10^4 is length of the grid.
Binary search in range [1...row*col] take log(row*col).
Each binary search, we need to bfs in the grid to check if it's good or not,
bfs takes O(E+V), where E=4*V (because each cells have up to 4 neighbors),
so time complexity is O(E+V) = O(4V+V) = O(5V) ~ O(row*col).
So total time complexity is O(row*col * log(row*col))

Space: O(row*col)
 */
public class LastDayWhereYouCanStillCross {

    public static void main(String[] args) {
        int row = 3,col =3;
        int[][] cells = new int[][]{
                {1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}
        };
        System.out.println(new LastDayWhereYouCanStillCross().latestDayToCross(row,col,cells));
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left =1, right = cells.length, ans =0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(canWeWalk(cells, row, col, mid)){
                ans = mid; // Update current answer so far
                left = mid+1;// Try to find a larger day
            } else{
                right = mid-1;// Try to find a smaller day
            }
        }
        return ans;
    }

    int[] dir= new int[]{0,1,0,-1,0};

    boolean canWeWalk(int[][] cells, int row, int col, int dayAt){
        int[][] grid = new int[row][col];

        for(int i=0;i<dayAt;i++){
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }

        Queue<int[]> q = new LinkedList<>();
        for(int c =0; c<col;c++){
            if(grid[0][c]==0){
                // Add all valid start cells in the top row
                q.offer(new int[]{0,c});
                grid[0][c]=1;
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if(r==row-1){
                // Reached to bottom -> Return Valid
                return true;
            }

            for(int i=0;i<4;i++){
                int x = r+dir[i], y = c+dir[i+1];
                if(x>=0 && x<row && y>=0 && y<col && grid[x][y]==0){
                    // Mark as visited
                    grid[x][y]=1;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return false;
    }
}
