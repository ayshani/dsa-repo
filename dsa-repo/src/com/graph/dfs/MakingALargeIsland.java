package com.graph.dfs;

import java.util.*;

/*
827. Making A Large Island

You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.



Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.

PreWord
-----------
The solution is long, but in fact it is really straight forward.
I suggest not going into my codes but reading my explanations, which should be enough.

Prepare
I have several simple sub function to help me on this kind of problem.

valid(int x, int y), check if (x, y) is valid in the grid.
move(int x, int y), return all possible next position in 4 directions.
Explanation
Only 2 steps:

Explore every island using DFS, count its area, give it an island index and save the result to a {index: area} map.
Loop every cell == 0, check its connected islands and calculate total islands area.

Complexity
----------
Time O(N^2)
Space O(N^2)

 */
public class MakingALargeIsland {
    int n;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0},{0,1}
        };
        System.out.println(new MakingALargeIsland().largestIsland(grid));
    }
    public int largestIsland(int[][] grid) {
        n = grid.length;
        //DFS every island and give it an index of island
        int index =3, res =0;
        Map<Integer,Integer> area = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    area.put(index, dfs(grid, i,j, index));
                    res = Math.max(res, area.get(index++));
                }
            }
        }

        //traverse every 0 cell and count biggest island it can conntect
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int cur =1;
                    Set<Integer> seen = new HashSet<>();
                    for(Pair p : move(i,j)){
                        int curIndex = grid[p.x][p.y];
                        if(curIndex>1 && !seen.contains(curIndex)){
                            seen.add(curIndex);
                            cur+= area.get(curIndex);
                        }
                    }
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y, int index){
        grid[x][y]= index;
        int area =0;
        for(Pair p : move(x,y)){
            if(grid[p.x][p.y]==1){
                area+= dfs(grid, p.x, p.y, index);
            }
        }
        return area+1;
    }

    private List<Pair> move(int x, int y){
        List<Pair> neighbourList = new ArrayList<>();
        if(isValid(x,y+1))
            neighbourList.add(new Pair(x,y+1));
        if(isValid(x,y-1))
            neighbourList.add(new Pair(x,y-1));
        if(isValid(x-1,y))
            neighbourList.add(new Pair(x-1,y));
        if(isValid(x+1,y))
            neighbourList.add(new Pair(x+1,y));
        return neighbourList;
    }

    private boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }
}

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x =x;
        this.y = y;
    }
}
