package com.graph.representation;
/*
1267. Count Servers that Communicate


You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.



Example 1:Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.

TC : o(m*n)
SC: o(n)
 */
public class CountServersThatCommunicate {

    public static void main(String[] args) {
        System.out.println(new CountServersThatCommunicate().countServers(new int[][]{{1,0},{0,1}}));
    }
    public int countServers(int[][] grid) {
        int communicableServersCount = 0;
        int[] rowCounts = new int[grid[0].length];
        int[] lastServerInCol = new int[grid.length];
        for (int i = 0; i < lastServerInCol.length; i++) {
            lastServerInCol[i] = -1;
        }

        // First pass to count servers in each row and column
        for (int row = 0; row < grid.length; row++) {
            int serverCountInRow = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    serverCountInRow++;
                    rowCounts[col]++;
                    lastServerInCol[row] = col;
                }
            }
            // If there is more than one server in the row, increase the count
            if (serverCountInRow != 1) {
                communicableServersCount += serverCountInRow;
                lastServerInCol[row] = -1;
            }
        }

        // Second pass to check if servers can communicate
        for (int row = 0; row < grid.length; row++) {
            if (
                    lastServerInCol[row] != -1 &&
                            rowCounts[lastServerInCol[row]] > 1
            ) {
                communicableServersCount++;
            }
        }

        return communicableServersCount;
    }
}
