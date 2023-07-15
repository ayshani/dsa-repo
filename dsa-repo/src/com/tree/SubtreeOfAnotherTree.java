package com.tree;
/*
572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

TC : o(n)
SC: o(n)
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        TreeNode subRoot = new TreeNode(1);
        subRoot.left = new TreeNode(3);
        subRoot.right = new TreeNode(4);

        System.out.println(new SubtreeOfAnotherTree().isSubtree(root,subRoot));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootTraversal = new StringBuilder();
        // serialize given nodes
        serialize(root, rootTraversal);
        String s = rootTraversal.toString();

        StringBuilder subRootTraversal = new StringBuilder();
        // serialize subtree nodes
        serialize(subRoot, subRootTraversal);
        String pattern = subRootTraversal.toString();

        if(s.contains(pattern))
            return true;
        return false;
    }

    private void serialize(TreeNode root, StringBuilder rootTraversal) {
        if(root==null){
            rootTraversal.append("#");
            return;
        }
        rootTraversal.append("^" + root.val);
        serialize(root.left,rootTraversal);
        serialize(root.right,rootTraversal);
    }
}
