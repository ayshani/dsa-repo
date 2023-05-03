package com.graph.shortestpathalgorithm.allsource;
/*
https://www.youtube.com/watch?v=oNI0rf2P9gE
https://www.programiz.com/dsa/floyd-warshall-algorithm

Time Complexity
There are three loops. Each loop has constant complexities. So, the time complexity of the Floyd-Warshall
algorithm is O(n^3).

Space Complexity
The space complexity of the Floyd-Warshall algorithm is O(n^2).
 */
public class FloydWarshallAlgorithmV1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,43},{1,0,6},{(int)1e9,(int) 1e9,0}
        };
        FloydWarshallAlgorithmV1 obj = new FloydWarshallAlgorithmV1();
        obj.floydWarshall(matrix);
    }

    public void floydWarshall(int[][] graph){
        int n = graph.length;
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = graph[i][j];
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k]+ matrix[k][j]< matrix[i][j]){
                        matrix[i][j] = matrix[i][k]+ matrix[k][j];
                    }
                }
            }
        }

        print(matrix, n);
    }

    private void print(int[][] matrix, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1e9)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}
