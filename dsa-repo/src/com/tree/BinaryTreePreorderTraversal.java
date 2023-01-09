package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example :
Input: root = [1,null,2,3]
Output: [1,2,3]

TC : o(n)
SC : o(n)
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();

        preorder(root,ls);

        return ls;
    }

    void preorder(TreeNode root, List<Integer> ls){
        if(root==null)
            return;
        ls.add(root.val);
        preorder(root.left,ls);
        preorder(root.right,ls);
    }
}
