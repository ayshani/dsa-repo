package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: root = [1,null,2,3]
            1
               2
             3
Output: [1,3,2]

TC : o(n)
SC : o(n)
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);

        return result;
    }

    private void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
