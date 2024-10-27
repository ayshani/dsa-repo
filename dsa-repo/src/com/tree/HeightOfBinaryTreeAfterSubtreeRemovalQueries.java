package com.tree;

import java.util.Arrays;

/*
2458. Height of Binary Tree After Subtree Removal Queries

You are given the root of a binary tree with n nodes. Each node is assigned a unique value from 1 to n. You are also
given an array queries of size m.

You have to perform m independent queries on the tree where in the ith query you do the following:

Remove the subtree rooted at the node with the value queries[i] from the tree. It is guaranteed that queries[i] will
not be equal to the value of the root.
Return an array answer of size m where answer[i] is the height of the tree after performing the ith query.

Note:

The queries are independent, so the tree returns to its initial state after each query.
The height of a tree is the number of edges in the longest simple path from the root to some node in the tree.


Example 1:
Input: root = [1,3,4,2,null,6,5,null,null,null,null,null,7], queries = [4]
Output: [2]
Explanation: The diagram above shows the tree after removing the subtree rooted at node with value 4.
The height of the tree is 2 (The path 1 -> 3 -> 2).

TC : o(n+q)
SC:  o(n)
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

    // Array to store the maximum height of the tree after removing each node
    static final int[] maxHeightAfterRemoval = new int[100001];

    int currentMaxHeight = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(1 );
        root2.right = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println(Arrays.toString(new HeightOfBinaryTreeAfterSubtreeRemovalQueries().treeQueries(root
        ,new int[]{4})));
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        traverseLeftToRight(root, 0);
        currentMaxHeight = 0; // Reset for the second traversal
        traverseRightToLeft(root, 0);

        // Process queries and build the result array
        int queryCount = queries.length;
        int[] queryResults = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            queryResults[i] = maxHeightAfterRemoval[queries[i]];
        }

        return queryResults;
    }

    private void traverseLeftToRight(TreeNode node, int currentHeight) {
        if (node == null) return;

        // Store the maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = currentMaxHeight;

        // Update the current maximum height
        currentMaxHeight = Math.max(currentMaxHeight, currentHeight);

        // Traverse left subtree first, then right
        traverseLeftToRight(node.left, currentHeight + 1);
        traverseLeftToRight(node.right, currentHeight + 1);
    }

    private void traverseRightToLeft(TreeNode node, int currentHeight) {
        if (node == null) return;

        // Update the maximum height if this node were removed
        maxHeightAfterRemoval[node.val] = Math.max(
                maxHeightAfterRemoval[node.val],
                currentMaxHeight
        );

        // Update the current maximum height
        currentMaxHeight = Math.max(currentHeight, currentMaxHeight);

        // Traverse right subtree first, then left
        traverseRightToLeft(node.right, currentHeight + 1);
        traverseRightToLeft(node.left, currentHeight + 1);
    }
}
