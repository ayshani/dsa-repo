package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
835. Image Overlap

You are given two images, img1 and img2, represented as binary, square matrices of size n x n.
A binary matrix has only 0s and 1s as values.

We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number
of units. We then place it on top of the other image. We can then calculate the overlap by counting the number
of positions that have a 1 in both images.

Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of
the matrix borders are erased.

Return the largest possible overlap.

Example 1:
Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We translate img1 to right by 1 unit and down by 1 unit.
1 1 0       0 1 1      0 0 0
0 1 0  ->   0 0 1  ->  0 1 1
0 1 0       0 0 1      0 0 1


Complexity Analysis
---------------
Let M_a, M_b be the number of non-zero cells in the matrix A and B respectively. Let N be the width of the matrix.

Time Complexity: O(N^4)
In the first step, we filter out the non-zero cells in each matrix, which would take O(N^2)
In the second step, we enumerate the cartesian product of non-zero cells between the two matrices,
which would take O(M_a. M_b) time. In the worst case, both M_a and M_b would be up to N^2, i.e. matrix filled with ones.

To sum up, the overall time complexity of the algorithm would be O(N^2) + O(N^2 . N^2) = O(N^4)
Although this approach has the same time complexity as the previous approach, it should run faster in practice,
since we ignore those zero cells.

Space Complexity: O(N^2)

We kept the indices of non-zero cells in both matrices. In the worst case, we would need the O(N^2)
 space for the matrices filled with ones.
 */
public class ImageOverlap {

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1,1,0},{0,1,0},{0,1,0}
        };
        int[][] B = new int[][]{
                {0,0,0},{0,1,1},{0,0,1}
        };
        System.out.println(new ImageOverlap().largestOverlap(A,B));
    }
    public int largestOverlap(int[][] A, int[][] B) {
        List<Pair> A_ones = non_zero_cells(A);
        List<Pair> B_ones = non_zero_cells(B);

        int maxOverlaps = 0;
        HashMap<Pair, Integer> groupCount = new HashMap<>();

        for (Pair a : A_ones)
            for (Pair b : B_ones) {
                Pair vec =
                        new Pair(b.getKey() - a.getKey(), b.getValue() - a.getValue());

                if (groupCount.containsKey(vec)) {
                    groupCount.put(vec, groupCount.get(vec) + 1);
                } else {
                    groupCount.put(vec, 1);
                }
                maxOverlaps = Math.max(maxOverlaps, groupCount.get(vec));
            }

        return maxOverlaps;
    }

    protected List<Pair> non_zero_cells(int[][] M) {
        List<Pair> ret = new ArrayList<>();
        for (int row = 0; row < M.length; ++row)
            for (int col = 0; col < M.length; ++col)
                if (M[row][col] == 1)
                    ret.add(new Pair(row, col));
        return ret;
    }
}


class Pair {
    Integer key;
    Integer value;

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
