package com.heap.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
2146. K Highest Ranked Items Within a Price Range

You are given a 0-indexed 2D integer array grid of size m x n that represents a map of the items in a shop.
The integers in the grid represent the following:

0 represents a wall that you cannot pass through.
1 represents an empty cell that you can freely move to and from.
All other positive integers represent the price of an item in that cell.
You may also freely move to and from these item cells.
It takes 1 step to travel between adjacent grid cells.

You are also given integer arrays pricing and start where pricing = [low, high] and start = [row, col]
indicates that you start at the position (row, col) and are interested only in items with a price in the
range of [low, high] (inclusive). You are further given an integer k.

You are interested in the positions of the k highest-ranked items whose prices are within the given price range.
The rank is determined by the first of these criteria that is different:

Distance, defined as the length of the shortest path from the start (shorter distance has a higher rank).
Price (lower price has a higher rank, but it must be in the price range).
The row number (smaller row number has a higher rank).
The column number (smaller column number has a higher rank).
Return the k highest-ranked items within the price range sorted by their rank (highest to lowest).
If there are fewer than k reachable items within the price range, return all of them.

Example 1:
Input: grid = [[1,2,0,1],[1,3,0,1],[0,2,5,1]], pricing = [2,5], start = [0,0], k = 3
        1  2  0  1
        1  3  0  1
        0  2  5  1
Output: [[0,1],[1,1],[2,1]]
Explanation: You start at (0,0).
With a price range of [2,5], we can take items from (0,1), (1,1), (2,1) and (2,2).
The ranks of these items are:
- (0,1) with distance 1
- (1,1) with distance 2
- (2,1) with distance 3
- (2,2) with distance 4
Thus, the 3 highest ranked items in the price range are (0,1), (1,1), and (2,1).

Time: O(R * C * log(R * C)),
space: O(R * C),
where R = grid.length, C = grid[0].length.
 */
public class KHighestRankedItemsWithinAPriceRange {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,0,1},{1,3,0,1},{0,2,5,1}
        };

        int[] start = new int[]{0,0}, pricing = new int[]{2,5};
        int k = 3;
        System.out.println(new KHighestRankedItemsWithinAPriceRange().highestRankedKItems(grid,pricing,start,k));
    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int R = grid.length, C = grid[0].length;

        int x = start[0], y = start[1], low = pricing[0], high = pricing[1];

        List<List<Integer>> result = new ArrayList<>();

        // PriorityQueue sorted by (distance, price, row, col).
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)
                -> a[0]==b[0] ?(a[1]==b[1] ? (a[2]==b[2]? a[3]-b[3]: a[2]-b[2]) : a[1]-b[1]) : a[0]-b[0]);

        pq.offer(new int[]{0,grid[x][y],x,y}); // BFS starting point.
        grid[x][y]*=-1;
        while(!pq.isEmpty() && result.size()<k){
            int[] current = pq.poll();
            // distance, price, row & column.
            int distance = current[0], price = current[1], row = current[2], column = current[3];

            if(price>=low && price<=high){ // price in range?
                result.add(Arrays.asList(row,column));
            }

            for(int m =0;m<4;m++){ // traverse 4 neighbors.
                int indexX = row+ dir[m][0], indexY = column + dir[m][1];

                // in boundary, not wall, and not visited yet?
                if(indexX>=0 && indexX<R && indexY>=0 && indexY <C && grid[indexX][indexY]>0){
                    pq.offer(new int[]{distance+1, grid[indexX][indexY] , indexX,indexY });
                    grid[indexX][indexY]*=-1;
                }
            }
        }

        return result;
    }
}
