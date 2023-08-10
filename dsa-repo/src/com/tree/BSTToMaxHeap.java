package com.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
BST to max heap
https://practice.geeksforgeeks.org/problems/bst-to-max-heap/1

Given a Binary Search Tree. Convert a given BST into a Special Max Heap with the condition that all the values
in the left subtree of a node should be less than all the values in the right subtree of the node.
This condition is applied on all the nodes in the so converted Max Heap.

Example 1:

Input :
                 4
               /   \
              2     6
            /  \   /  \
           1   3  5    7

Output : 1 2 3 4 5 6 7
Exaplanation :
               7
             /   \
            3     6
          /   \  /   \
         1    2 4     5
The given BST has been transformed into a
Max Heap and it's postorder traversal is
1 2 3 4 5 6 7.

TC : o(n)
SC: o(n)

 */
public class BSTToMaxHeap {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        convertToMaxHeapUtil(root);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    static int i;
    public static void convertToMaxHeapUtil(TreeNode root)
    {
        //code here
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        i=0;
        bstToHeap(root, nums);
    }

    static private void bstToHeap(TreeNode root, List<Integer> nums){
        if(root==null)
            return;
        bstToHeap(root.left, nums);
        bstToHeap(root.right, nums);
        root.val = nums.get(i++);

    }

    static private void inorder(TreeNode root, List<Integer> nums){
        if(root==null)
            return;

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
