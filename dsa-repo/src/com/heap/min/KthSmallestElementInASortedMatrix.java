package com.heap.min;

import java.util.PriorityQueue;

/*
378. Kth Smallest Element in a Sorted Matrix

Given an n x n matrix where each of the rows and columns is sorted in ascending order,
return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Logic
------
Min Heap to find kth smallest element from amongst N sorted list

Since each of the rows in matrix are already sorted, we can understand the problem as
finding the kth smallest element from amongst M sorted rows.
We start the pointers to point to the beginning of each rows, then we iterate k times, for each time ith,
the top of the minHeap is the ith smallest element in the matrix.
We pop the top from the minHeap then add the next element which has the same row with that top to the minHeap.

TC : o(klogk)
SC : o(k)
 */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,5,9} ,
                {10,11,13},
                {12,13,15}
        };
        int k =8;
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix,k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0]-b[0]);

        for(int i=0;i<Math.min(m,k);i++){
            pq.offer(new int[]{matrix[i][0],i,0});
        }

        for(int i=1;i<=k;i++){
            int[] cur = pq.poll();
            int r = cur[1], c = cur[2];
            ans =cur[0];

            if(c<n-1)
                pq.offer(new int[]{matrix[r][c+1],r,c+1});
        }

        return ans;
    }
}
