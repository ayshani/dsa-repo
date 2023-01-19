package com.matrix;

import java.util.*;

/*
1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix

Given a m x n binary matrix mat. In one step, you can choose one cell and flip it and all
the four neighbors of it if they exist (Flip is changing 1 to 0 and 0 to 1).
A pair of cells are called neighbors if they share one edge.

Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.

A binary matrix is a matrix with all cells equal to 0 or 1 only.

A zero matrix is a matrix with all cells equal to 0.


Example 1:
Input: mat = [[0,0],[0,1]]
Output: 3
    0 0  ->  1 0  ->  0 1  -> 0 0
    0 1      1 0      1 1     0 0
Explanation: One possible solution is to flip (1, 0) then (0, 1) and finally (1, 1) as shown.

Explanation
-----------
the idea is to use BFS to generate all combinations using flip and put it in queue.
once a level of combination is generated, we check
    1. if it reaches the target, if yes, returm the total steps of flip required.
    2. if not then, check whether any of the combination is visited already or not,
        if not visited, then add to visited set and add in queue.

Here one level means all combination from a specific mat[][] orientation.

TC : o(m*n * 2^(m*n))
SC : o(2^m*n)
 */
public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0,0},{0,1}
        };
        System.out.println(new MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix().minFlips(mat));
    }
    public int minFlips(int[][] mat) {
        Deque<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        if(isTarget(mat))
            return 0;

        queue.offer(mat);
        visited.add(serialize(mat));
        int distance =0;
        while(!queue.isEmpty()){ // o(all number of combinations of mat)
            int size = queue.size();
            while(size-->0){
                int[][] currentMat = queue.poll();
                for(int[][] next : getNext(currentMat)){
                    if(isTarget(next))
                        return distance+1;
                    String strNext = serialize(next);
                    if(!visited.contains(strNext)){
                        visited.add(strNext);
                        queue.offer(next);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    private boolean isTarget(int[][] mat){
        for(int row[] : mat){
            for(int num : row){
                if(num!=0)
                    return false;
            }
        }
        return true;
    }


    private String serialize(int[][] mat){
        StringBuilder sb = new StringBuilder();
        for(int row[] : mat){
            for(int num : row){
                sb.append(num);
            }
            sb.append(".");
        }
        return sb.toString();
    }

    //o(2^(m*n))
    private List<int[][]> getNext(int[][] mat){
        List<int[][]> list = new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                list.add(flip(mat,i,j));
            }
        }
        return list;
    }


    private int[][] flip(int[][] mat, int row, int col){
        int m = mat.length, n = mat[0].length;
        int[][] newMat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==row && j==col) || (i==row-1 && j==col) ||
                        (i==row+1 && j== col) || (i==row && j== col-1) ||
                        (i== row && j==col+1)){
                    newMat[i][j] = 1- mat[i][j];

                }
                else{
                    newMat[i][j] = mat[i][j];
                }
            }
        }
        return newMat;
    }
}
