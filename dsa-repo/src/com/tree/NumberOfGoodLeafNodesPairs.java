package com.tree;


import com.tree.TreeNode;

import java.util.*;

/*
1530. Number of Good Leaf Nodes Pairs

You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary
tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.

Example 1:
Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3.
This is the only good pair.

TC : o(n^2)
SC: o(n)
 */
public class NumberOfGoodLeafNodesPairs {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(root,3));
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        traverseTree(root, null, graph, leafNodes);

        int ans = 0;

        for (TreeNode leaf : leafNodes) {
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            Set<TreeNode> seen = new HashSet<>();
            bfsQueue.add(leaf);
            seen.add(leaf);

            for (int i = 0; i <= distance; i++) {
                int size = bfsQueue.size();
                for (int j = 0; j < size; j++) {
                    TreeNode currNode = bfsQueue.remove();
                    if (leafNodes.contains(currNode) && currNode != leaf) {
                        ans++;
                    }
                    if (graph.containsKey(currNode)) {
                        for (TreeNode neighbor : graph.get(currNode)) {
                            if (!seen.contains(neighbor)) {
                                bfsQueue.add(neighbor);
                                seen.add(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return ans/2;
    }

    private void traverseTree(
            TreeNode currNode,
            TreeNode prevNode,
            Map<TreeNode, List<TreeNode>> graph,
            Set<TreeNode> leafNodes
    ) {
        if (currNode == null) {
            return;
        }

        if (currNode.left == null && currNode.right == null) {
            leafNodes.add(currNode);
        }
        if (prevNode != null) {
            graph.computeIfAbsent(prevNode, k -> new ArrayList<TreeNode>()).add(currNode);
            graph.computeIfAbsent(currNode, k -> new ArrayList<TreeNode>()).add(prevNode);

        }
        traverseTree(currNode.left, currNode, graph, leafNodes);
        traverseTree(currNode.right, currNode, graph, leafNodes);

    }
}
