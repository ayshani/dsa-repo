package com.linkedlist;
/*
 * 114. Flatten Binary Tree to Linked List
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child
 *  pointer points to the next node in the list and the left child pointer is always null.
 *
 *  The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 *       1             1
 *    2      5     ->     2
 *  3    4     6             3
 *                              4
 *                                 5
 *                                   6
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Logic
 * ----------------
 * Have one prev pointer initialised as null
 * traverse the tree for right-left-root.
 * and keep assigning the prev to current root
 *
 * TC : o(n)
 * SC : o(1)
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right =  new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        obj.flatten(root);

        obj.print(root);
    }

    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    private void print(TreeNode root) {
        if(root==null)
        {
            System.out.print("null" +" ");
            return;

        }
        System.out.print(root.val +" ");
        print(root.left);
        print(root.right);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


