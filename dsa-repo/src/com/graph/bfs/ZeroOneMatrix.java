package com.graph.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.



Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

TC : o(m*n)
SC: o(m*n)
 */
public class ZeroOneMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,0,0},{0,1,0},{1,1,1}
        };
        int[][] res = new ZeroOneMatrix().updateMatrix(mat);
        Arrays.stream(res).forEach(e -> {Arrays.stream(e).forEach(i -> System.out.print(i+" "));
            System.out.println();});

    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Deque<Integer[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)
                {
                    q.offer(new Integer[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        int count =0;
        int[] dir = new int[]{0,1,0,-1,0};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Integer[] cur = q.poll();
                int i = cur[0], j =cur[1];
                if(mat[i][j]==1){
                    res[i][j] = count;
                }
                for(int d=0;d<4;d++){
                    int x = dir[d] + i, y = dir[d+1] + j;
                    if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
                        q.offer(new Integer[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            count++;
        }
        return res;
    }
}
