package com.heap.min;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1337. The K Weakest Rows in a Matrix

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all
the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].

TC : o(nlogn)
SC : o(n)
 */
public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}
        };

        int[] res = new TheKWeakestRowsInAMatrix().kWeakestRows(mat,3);
        Arrays.stream(res).forEach(e-> System.out.print(e +" "));
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[k];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0]==b[0] ? a[1]-b[1]:
                        a[0]-b[0]);
        for(int i=0;i<n;i++){
            int[] temp = mat[i];
            pq.offer(new int[]{Arrays.stream(temp).sum(),i});
        }
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}
