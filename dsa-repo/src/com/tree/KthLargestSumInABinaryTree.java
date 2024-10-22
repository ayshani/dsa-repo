package com.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
2583. Kth Largest Sum in a Binary Tree

You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.



Example 1:
Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Output: 13
Explanation: The level sums are the following:
- Level 1: 5.
- Level 2: 8 + 9 = 17.
- Level 3: 2 + 1 + 3 + 7 = 13.
- Level 4: 4 + 6 = 10.
The 2nd largest level sum is 13.

TC : o(logN*logk)
SC: o(n)
 */
public class KthLargestSumInABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right =  new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right =  new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(new KthLargestSumInABinaryTree().kthLargestLevelSum(root, 2));
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        // min heap of size k
        // at the end, top element is kth largest
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            //level order traversal
            int size = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = bfsQueue.remove();
                sum += poppedNode.val;
                if (poppedNode.left != null) {
                    //add left child
                    bfsQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    // add right child
                    bfsQueue.add(poppedNode.right);
                }
            }

            pq.add(sum);
            if (pq.size() > k) {
                // evict top element
                pq.remove();
            }
        }
        if (pq.size() < k) return -1;
        return pq.peek();
    }
}
