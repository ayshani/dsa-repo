package com.graph.bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
2328. Number of Increasing Paths in a Grid

You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell.
Since the answer may be very large, return it modulo 109 + 7.

Two paths are considered different if they do not have exactly the same sequence of visited cells.

Example 1:
Input: grid = [[1,1],[3,4]]
Output: 8
Explanation: The strictly increasing paths are:
- Paths with length 1: [1], [1], [3], [4].
- Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
- Paths with length 3: [1 -> 3 -> 4].
The total number of paths is 4 + 3 + 1 = 8.

 */
public class NumberOfIncreasingPathsInAGrid {

    public static void main(String[] args) {
        int[][] grid =  new int[][]{{1,1},{3,4}};
        System.out.println(new NumberOfIncreasingPathsInAGrid().countPathsV2(grid));
    }

    /*
    Approach : Sorting + DP + graph traversal
    this process is very time-consuming as we need to sort all the cell first to get started.
    TC : o(m*n*log(m*n)
        We sort all cells by value, it takes O(klogk) to sort an array of size O(k), so it takes
        O(m⋅n⋅log(m⋅n)) time.
        The iteration over sorted cells has O(m⋅n) steps, each step consists of checking at most four neighbor cells,
        thus it takes O(m⋅n) time.
        For initialization of dp and the calculation of answer we iterate over all the cells of the dp array,
        which also takes O(m⋅n) time.
        To sum up, the overall time complexity is O(m⋅n⋅log(m⋅n)).

    SC: o(mn)
     */
    public int countPaths(int[][] grid) {
        long res =0, MOD = 1000000007;
        int m = grid.length, n = grid[0].length;

        /*
        dp[i][j] means the number of paths ending at A[i][j].
        We initial all dp[i][j] = 1.
        */
        long[][] dp = new long[m][n];

        for(int i=0;i<m;i++){
            //base case of every node is 1 , aka this node is smaller than all neighbors
            Arrays.fill(dp[i],1);
        }
        // minHeap, traverse all neighbour nodes from smallest to biggest
        PriorityQueue<int[]> pq = new PriorityQueue<>(new ArrayComparator());

        // add all cell in pq.
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.offer(new int[]{grid[i][j],i,j});
            }
        }

        int[] direction = new int[]{0,1,0,-1,0};
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int i=0;i<4;i++){
                int x = cur[1] + direction[i];
                int y = cur[2] + direction[i+1];
                // check if it's bounded and current value of grid is less than its neighbour, then
                // update the count in dp of neighbour
                if(x>=0 && x<m && y>=0 && y<n && grid[x][y]> cur[0]){
                    dp[x][y] = (dp[x][y] + dp[cur[1]][cur[2]])%MOD;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = (res+dp[i][j])%MOD;
            }
        }

        return (int)res;
    }

    /*
    Approach : DFS + DP(memoization)
    Time complexity: O(m⋅n)
    We used dp as memory to avoid repeated computation, so each cell is only visited and calculated once.
    Initialization of the dp array also takes O(m⋅n) time.
    Space complexity: O(m⋅n)

    We build the auxiliary array dp of the same size as grid.
    The space complexity of recursive algorithm is proportional to the maximum depth of the recursion tree generated. There are at most m⋅nm\cdot nm⋅n recursive call of dfs in the stack simulaneously, thus the stack takes O(m⋅n)O(m\cdot n)O(m⋅n) space.
    To sum up, the space complexity is O(m⋅n).
     */
    int[] direction = new int[]{0,1,0,-1,0};
    int MOD = 1000000007;

    public int countPathsV2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // Iterate over all cells grid[i][j] and sum over dfs(i, j).
        int answer =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                answer = (answer+ dfs(grid,i,j,dp))%MOD;
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int i, int j, int[][] dp){
        // If dp[i][j] is non-zero, it means we have got the value of dfs(i, j),
        // so just return dp[i][j].
        if(dp[i][j]!=0)
            return dp[i][j];

        // Otherwise, set answer = 1, the path made of grid[i][j] itself.
        int answer = 1;

        // Check its four neighbor cells, if a neighbor cell grid[prevI][prevJ] has a
        // smaller value, we move to this cell and solve the subproblem: dfs(prevI, prevJ).
        for(int d=0;d<4;d++){
            int prevI = i + direction[d];
            int prevJ = j + direction[d+1];
            if(prevI>=0 && prevI<grid.length && prevJ>=0 && prevJ<grid[0].length
                    && grid[prevI][prevJ] < grid[i][j]){
                answer  = (answer + dfs(grid,prevI,prevJ,dp))%MOD;
            }
        }
        // Update dp[i][j], so that we don't recalculate its value later.
        return dp[i][j] = answer;
    }
}

class ArrayComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] < a2[i]) {
                return -1;
            } else if (a1[i] > a2[i]) {
                return 1;
            }
        }
        return 0;
    }
}
