package com.tree.segmenttree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

/*
3161. Block Placement Queries
There exists an infinite number line, with its origin at 0 and extending towards the positive x-axis.

You are given a 2D array queries, which contains two types of queries:

For a query of type 1, queries[i] = [1, x]. Build an obstacle at distance x from the origin. It is guaranteed that there is no obstacle at distance x when the query is asked.
For a query of type 2, queries[i] = [2, x, sz]. Check if it is possible to place a block of size sz anywhere in the range [0, x] on the line, such that the block entirely lies in the range [0, x]. A block cannot be placed if it intersects with any obstacle, but it may touch it. Note that you do not actually place the block. Queries are separate.
Return a boolean array results, where results[i] is true if you can place the block specified in the ith query of type 2, and false otherwise.



Example 1:

Input: queries = [[1,2],[2,3,3],[2,3,1],[2,2,2]]

Output: [false,true,true]

Explanation:
For query 0, place an obstacle at x = 2. A block of size at most 2 can be placed before x = 3.
 */
public class BlockPlacementQueries {

    public static void main(String[] args) {
        System.out.println(new BlockPlacementQueries().getResults(new int[][]{{1,2},{2,3,3},{2,3,1},{2,2,2}}));
    }
    private int[] seg;

    private void update(int idx, int val, int p, int l, int r) {
        if (l == r) {
            seg[p] = val;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) {
            update(idx, val, p << 1, l, mid);
        } else {
            update(idx, val, (p << 1) | 1, mid + 1, r);
        }
        seg[p] = Math.max(seg[p << 1], seg[(p << 1) | 1]);
    }

    private int query(int L, int R, int p, int l, int r) {
        if (L <= l && r <= R) {
            return seg[p];
        }
        int mid = (l + r) >> 1;
        int res = 0;
        if (L <= mid) {
            res = Math.max(res, query(L, R, p << 1, l, mid));
        }
        if (R > mid) {
            res = Math.max(res, query(L, R, (p << 1) | 1, mid + 1, r));
        }
        return res;
    }

    public List<Boolean> getResults(int[][] queries) {
        int mx = 50000;
        seg = new int[mx << 2];
        TreeSet<Integer> st = new TreeSet<>();
        st.add(0);
        st.add(mx);
        update(mx, mx, 1, 0, mx);
        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                int r = Optional.ofNullable(st.ceiling(x + 1)).orElse(mx);
                int l = Optional.ofNullable(st.floor(x - 1)).orElse(0);
                update(x, x - l, 1, 0, mx);
                update(r, r - x, 1, 0, mx);
                st.add(x);
            } else {
                int x = q[1];
                int sz = q[2];
                int pre = Optional.ofNullable(st.floor(x)).orElse(0);
                int max_space = query(0, pre, 1, 0, mx);
                max_space = Math.max(max_space, x - pre);
                ans.add(max_space >= sz);
            }
        }
        return ans;
    }
}
