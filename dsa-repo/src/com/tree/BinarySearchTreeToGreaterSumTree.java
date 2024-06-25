package com.tree;
/*
1038. Binary Search Tree to Greater Sum Tree

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original
BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

TC : o(n)
SC: o(logn)
 */
public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(22);
        root.left.right = new TreeNode(5);
        root = new BinarySearchTreeToGreaterSumTree().bstToGst(root);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    int pre =0;
    public TreeNode bstToGst(TreeNode root) {
        if(root.right!=null)
            bstToGst(root.right);

        pre = root.val = pre+ root.val;

        if(root.left!=null)
            bstToGst(root.left);

        return root;
    }
}
