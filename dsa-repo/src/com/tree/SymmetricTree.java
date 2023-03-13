package com.tree;
/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

TC : o(n)
SC: o(logn)
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return util(root.left,root.right);
    }

    private boolean util(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null){
            return false;
        }
        return left.val == right.val && util(left.left, right.right)
                && util(left.right , right.left);
    }
}
