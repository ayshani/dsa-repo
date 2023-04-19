package com.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/*
1992. Find All Groups of Farmland

You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land and a 1
represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares that consist entirely of farmland.
These rectangular areas are called groups. No two groups are adjacent, meaning farmland in one group is not
four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of land is (0, 0) and the bottom right
corner of land is (m-1, n-1). Find the coordinates of the top left and bottom right corner of each group of farmland.
A group of farmland with a top left corner at (r1, c1) and a bottom right corner at (r2, c2) is represented by
the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group of farmland in land. If there are
no groups of farmland, return an empty array. You may return the answer in any order.

Example 1:
Input: land = [[1,0,0],[0,1,1],[0,1,1]]
Output: [[0,0,0,0],[1,1,2,2]]
Explanation:
The first group has a top left corner at land[0][0] and a bottom right corner at land[0][0].
The second group has a top left corner at land[1][1] and a bottom right corner at land[2][2].

TC: o(m*n)
SC: o(1)
 */
public class FindAllGroupsOfFarmland {

    public static void main(String[] args) {
        int[][] land = new int[][]{
                {1,0,0},{0,1,1},{0,1,1}
        };
        System.out.println(new FindAllGroupsOfFarmland().findFarmland(land));
    }
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;

        List<int[]> result= new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==1){
                    dfs(land, i,j,m,n,result);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private void dfs(int[][] land, int i, int j, int m, int n, List<int[]> result){
        int endX = i, endY =j;
        //Find ending y co-ordinate for the Farmland
        while(endY+1<n && land[i][endY+1]==1){
            land[i][endY]=0;
            endY++;
        }
        //Find ending x co-ordinate for the Farmland
        while(endX+1<m && land[endX+1][j]==1){
            land[endX][j]=0;
            endX++;
        }

        //Fill the rectangular Farmland with zeroes
        //To avoid revisitng/recounting
        for(int x= i;x<=endX;x++){
            for(int y=j;y<=endY;y++){
                land[x][y] = 0;
            }
        }
        result.add(new int[]{i,j,endX,endY});
    }
}
