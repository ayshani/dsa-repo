package com.graph.dfs;
/*
547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

TC: o(n)
SC: o(logn)
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        };
        System.out.println(new NumberOfProvinces().findCircleNum(mat));
    }
    public int findCircleNum(int[][] isConnected) {
        int count =0, m = isConnected.length;

        for(int i=0;i<m;i++){
            if(isConnected[i][i]==1){
                count++;
                dfs(isConnected, i,m);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, int m){
        isConnected[i][i] = 0;
        for(int k=0;k<m;k++){
            if(isConnected[i][k]==1){
                isConnected[i][k] = 0;
                dfs(isConnected, k,m);
            } else{
                continue;
            }
        }
    }
}
