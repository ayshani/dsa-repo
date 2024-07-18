package com.tree;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode next;
    TreeNode random;

    TreeNode() {

    }

    TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
