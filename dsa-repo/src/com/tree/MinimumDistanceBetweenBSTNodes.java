package com.tree;
/*
783. Minimum Distance Between BST Nodes

Given the root of a Binary Search Tree (BST), return the minimum difference between
the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

TC : o(n)
SC: o(logn)
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(root));
    }
    int minDif = Integer.MAX_VALUE, prev =-1;
    public int minDiffInBST(TreeNode root) {
        util(root);
        return minDif;
    }


    private void util(TreeNode root){
        if(root==null)
            return ;
        util(root.left);
        if(prev!=-1 )
            minDif = Math.min(minDif,Math.abs(prev-root.val));
        prev=root.val;
        util(root.right);
    }
}
