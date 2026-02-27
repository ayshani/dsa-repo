package com.bit.manipulation;

import java.util.*;

/*
3666. Minimum Operations to Equalize Binary String

You are given a binary string s, and an integer k.

In one operation, you must choose exactly k different indices and flip each '0' to '1' and each '1' to '0'.

Return the minimum number of operations required to make all characters in the string equal to '1'. If it is not possible, return -1.



Example 1:

Input: s = "110", k = 1

Output: 1

Explanation:

There is one '0' in s.
Since k = 1, we can flip it directly in one operation.

TC : o(nlgn)
SC: o(n)

 */
public class MinimumOperationsToEqualizeBinaryString {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToEqualizeBinaryString().minOperations("110",1));
    }
    public int minOperations(String s, int k) {
        int n = s.length();
        int m = 0;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<TreeSet<Integer>> nodeSets = new ArrayList<>();
        nodeSets.add(new TreeSet<>());
        nodeSets.add(new TreeSet<>());
        for (int i = 0; i <= n; i++) {
            nodeSets.get(i % 2).add(i);
            if (i < n && s.charAt(i) == '0') {
                m++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(m);
        dist[m] = 0;
        nodeSets.get(m % 2).remove(m);
        while (!q.isEmpty()) {
            m = q.poll();
            int c1 = Math.max(k - n + m, 0);
            int c2 = Math.min(m, k);
            int lnode = m + k - 2 * c2;
            int rnode = m + k - 2 * c1;
            TreeSet<Integer> nodeSet = nodeSets.get(lnode % 2);
            for (
                    Integer m2 = nodeSet.ceiling(lnode);
                    m2 != null && m2 <= rnode;
                    m2 = nodeSet.ceiling(lnode)
            ) {
                dist[m2] = dist[m] + 1;
                q.offer(m2);
                nodeSet.remove(m2);
            }
        }
        return dist[0] == Integer.MAX_VALUE ? -1 : dist[0];
    }
}
