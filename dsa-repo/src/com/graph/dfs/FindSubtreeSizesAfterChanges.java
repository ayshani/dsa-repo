package com.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3331. Find Subtree Sizes After Changes

You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1. The tree is represented by an array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:

Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
If node y does not exist, do nothing.
Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.
Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.



Example 1:

Input: parent = [-1,0,0,1,1,1], s = "abaabc"

Output: [6,3,1,1,1,1]

Explanation:
The parent of node 3 will change from node 1 to node 0.

TC : o(n)
SC : o(n)
 */
public class FindSubtreeSizesAfterChanges {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindSubtreeSizesAfterChanges().findSubtreeSizes(
                new int[]{-1,0,0,1,1,1}, "abaabc"
        )));
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] saved = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);

        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int x = stack[--top];

            if (x >= 0) {
                int c = s.charAt(x) - 'a';
                saved[x] = last[c];
                last[c] = x;
                stack[top++] = ~x;
                for (int ch : children[x]) {
                    stack[top++] = ch;
                }
            } else {
                x = ~x;
                int c = s.charAt(x) - 'a';
                last[c] = saved[x];
                if (x != 0) {
                    int newParent = (saved[x] != -1) ? saved[x] : parent[x];
                    size[newParent] += size[x];
                }
            }
        }
        return size;
    }
}
