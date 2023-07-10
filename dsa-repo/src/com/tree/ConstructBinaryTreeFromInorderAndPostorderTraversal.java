package com.tree;

import com.concurrency.PrintInOrder;

import java.util.HashMap;
import java.util.Map;

/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

TC : o(n)
SC: o(n)
 */
    public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] in = new int[]{9,3,15,20,7}, post = new int[]{9,15,7,20,3};
        TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(in,post);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    Map<Integer,Integer > inorderIndexMap;
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        inorderIndexMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }

        return util(postorder,0,postorder.length-1);
    }

    private TreeNode util(int[] postorder, int left, int right){
        if(left>right || postOrderIndex<0)
            return null;
        int rootval = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootval);

        root.right = util(postorder,inorderIndexMap.get(rootval)+1,right);
        root.left = util(postorder,left, inorderIndexMap.get(rootval)-1);
        return root;
    }
}
