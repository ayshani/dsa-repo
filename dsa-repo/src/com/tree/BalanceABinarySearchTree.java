package com.tree;

import com.concurrency.PrintInOrder;

import java.util.ArrayList;
import java.util.List;

/*
1382. Balance a Binary Search Tree

Given the root of a binary search tree, return a balanced binary search tree with the same node values.
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Example 1:
Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

TC : o(n)
SC: o(n)
 */
public class BalanceABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        new TreeTraversal().printTreeLevelOrder(new BalanceABinarySearchTree().balanceBST(root));
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return createBST(inorder, 0, inorder.size()-1);
    }

    private void inorderTraversal(TreeNode root,List<Integer> inorder){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }

    private TreeNode createBST(List<Integer> inorder, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode left = createBST(inorder, start, mid-1);
        TreeNode right = createBST(inorder, mid+1, end);
        TreeNode node = new TreeNode(inorder.get(mid), left, right);
        return node;
    }


}
