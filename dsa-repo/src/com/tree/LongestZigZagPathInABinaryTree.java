package com.tree;
/*
1372. Longest ZigZag Path in a Binary Tree

You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Example 1:
Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Explanation:
----------------
When traversing binary tree if you took "left" child to reach node and now visiting "right" child,
you found 1 more depth path. So we keep track of the previous direction based on boolean true
(considered as right direction) and false (considered as a left direction).
When going left (node.left) if the previous direction was right you get depth+1 else you hit 2 left nodes in a row,
so you start from ZERO again, same for right child direction.

TC: o(n)
SC: o(logn)
 */
public class LongestZigZagPathInABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

        System.out.println(new LongestZigZagPathInABinaryTree().longestZigZag(root));
    }
    int max;
    public int longestZigZag(TreeNode root) {
        max =0;
        if(root==null)
            return 0;
        //try both directions, and choose the better one
        //direction: true is right, false is left
        dfs(root.left,0,false);
        dfs(root.right,0,true);
        return max;
    }

    private void dfs(TreeNode root, int depth, boolean direction){
        max = Math.max(max,depth);
        if(root==null)
            return;
        //if previous direction was right, and now going left, we add 1 to depth, else starting again as 0
        dfs(root.left, direction?depth+1:0,false);
        // this is viceversa
        dfs(root.right, !direction ? depth+1:0,true);

    }
}
