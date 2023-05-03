package com.graph.shortestpathalgorithm.allsource;
/*
https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph.
The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j.
If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.

Example 1:

Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
Output: {{0,1,7},{1,0,6},{-1,-1,0}}
Explanation: We can reach 2 from 0 as 0->1->2
and the cost will be 1+6=7 which is less than
43.

TC : o(n^3)
SC: o(n^2)
 */
public class FloydWarshallAlgorithmV2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,43},{1,0,6},{-1,-1,0}
        };
        FloydWarshallAlgorithmV2 obj = new FloydWarshallAlgorithmV2();
        obj.shortest_distance(matrix);
        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] +"  ") ;
            }
            System.out.println();
        }
    }
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(matrix[i][j]==-1){
                    matrix[i][j] = (int)1e9;
                }
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] =Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1e9){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
