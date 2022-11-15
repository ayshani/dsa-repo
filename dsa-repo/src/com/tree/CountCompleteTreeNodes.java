package com.tree;
/*
222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:
Input: root = [1,2,3,4,5,6]
                1
             2      3
          4    5  6
 Output: 6

Explanation
---------
The height of a tree can be found by just going left. Let a single node tree have height 0.
Find the height h of the whole tree. If the whole tree is empty, i.e., has height -1, there are 0 nodes.

Otherwise check whether the height of the right subtree is just one less than that of the whole tree,
meaning left and right subtree have the same height.

If yes, then the last node on the last tree row is in the right subtree and the
left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root
node plus recursively the number of nodes in the right subtree.

If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree
of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively
the number of nodes in the left subtree.


Since I halve the tree in every recursive step, I have O(log(n)) steps. Finding a height costs O(log(n)).
So overall O(log(n)^2).

 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        int h = height(root);
        return h<0 ? 0 : height(root.right) == h-1 ? (1<<h) + countNodes(root.right) :
                (1<< h-1) + countNodes(root.left);
    }

    private int height(TreeNode root){
        return root==null ? -1 : 1+ height(root.left);
    }
}
