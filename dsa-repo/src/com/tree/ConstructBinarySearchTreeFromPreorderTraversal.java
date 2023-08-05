package com.tree;

import com.linkedlist.PrintLinkedList;

/*
1008. Construct Binary Search Tree from Preorder Traversal

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree),
construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the
given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less
than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses
Node.right.

Example 1:
Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

TC : o(n)
SC: o(logn)
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};
        TreeNode root = new ConstructBinarySearchTreeFromPreorderTraversal().bstFromPreorder(preorder);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index=0;
        return solve(preorder, Integer.MAX_VALUE);
    }

    private TreeNode solve(int[] preorder, int bound){
        if(index==preorder.length || preorder[index]> bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = solve(preorder, root.val);
        root.right = solve(preorder, bound);
        return root;
    }
}
