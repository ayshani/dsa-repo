package com.graph.shortestpathalgorithm.singlesource.dijkstraalgo;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1368. Minimum Cost to Make at Least One Valid Path in a Grid

Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are
currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from
the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid.
The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

Example 1:
Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
Output: 3
Explanation: You will start at point (0, 0).
The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3)
change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0)
change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3)
change the arrow to down with cost = 1 --> (3, 3)
The total cost = 3.

Explanation:
So simple dijkstra algorithm is used. Start from top left index. Add all the four adjacent cells from a given cell
and new cost will be 1 + the cost of given cell. In case the new cell which is discovered is the same as that of
the path given by the given current cell than no need to add extra 1.

TC: o(nlogn)
SC: o(n)
 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,1,1,1},
                {2,2,2,2},
                {1,1,1,1},
                {2,2,2,2}
        };
        System.out.println(new MinimumCostToMakeAtLeastOneValidPathInAGrid().minCost(grid));
        System.out.println(new MinimumCostToMakeAtLeastOneValidPathInAGrid().minCostV2(grid));
    }
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a, b)-> a.cost - b.cost);
        pq.offer(new Tuple(0,0,0));

        boolean[][] visited = new boolean[m][n];
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            visited[cur.row][cur.col] = true;
            if(cur.row==m-1 && cur.col==n-1){
                return cur.cost;
            }

            if(cur.col+1!=n && !visited[cur.row][cur.col+1]){
                pq.offer(new Tuple(cur.row,cur.col+1, (grid[cur.row][cur.col]== 1? 0 : 1) + cur.cost));
            }
            if(cur.col-1!=-1 && !visited[cur.row][cur.col-1]){
                pq.offer(new Tuple(cur.row,cur.col-1, (grid[cur.row][cur.col]== 2? 0 : 1) + cur.cost));
            }
            if(cur.row+1!=m && !visited[cur.row+1][cur.col]){
                pq.offer(new Tuple(cur.row+1,cur.col, (grid[cur.row][cur.col]== 3? 0 : 1) + cur.cost));
            }
            if(cur.row-1!=-1 && !visited[cur.row-1][cur.col]){
                pq.offer(new Tuple(cur.row-1,cur.col, (grid[cur.row][cur.col]== 4? 0 : 1) + cur.cost));
            }
        }
        return 0;
    }

    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    /*
    TC : O(n⋅m⋅log(n⋅m))
    SC : O(n⋅m)
     */
    public int minCostV2(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;

        // Min-heap ordered by cost. Each element is [cost, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, 0 });

        // Track minimum cost to reach each cell
        int[][] minCost = new int[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }
        minCost[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];

            // Skip if we've found a better path to this cell
            if (minCost[row][col] != cost) continue;

            // Try all four directions
            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];

                // Check if new position is valid
                if (
                        newRow >= 0 &&
                                newRow < numRows &&
                                newCol >= 0 &&
                                newCol < numCols
                ) {
                    // Add cost=1 if we need to change direction
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);

                    // Update if we found a better path
                    if (minCost[newRow][newCol] > newCost) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[] { newCost, newRow, newCol });
                    }
                }
            }
        }

        return minCost[numRows - 1][numCols - 1];
    }
}

class Tuple {
    int row, col, cost;

    public Tuple(int r, int col, int cost){
        this.row =r;
        this.col = col;
        this.cost = cost;
    }

}