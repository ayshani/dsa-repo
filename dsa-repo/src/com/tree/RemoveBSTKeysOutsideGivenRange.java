package com.tree;
/*
Remove BST keys outside given range
https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1

Given a Binary Search Tree (BST) and a range [min, max], remove all keys which are outside the given range.
The modified tree should also be BST.

Example 1:

Input:
Range = [-10, 13]
Lightbox
Output:
-8 6 7 13
Explanation:
Nodes with values -13, 14 and 15 are
outside the given range and hence are
removed from the BST.

BinaryTreeModified2
This is the resultant BST and it's
inorder traversal is -8 6 7 13.

TC : o(n)
SC : o(logn)
 */
public class RemoveBSTKeysOutsideGivenRange {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root = new RemoveBSTKeysOutsideGivenRange().removekeys(root,2,7);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    TreeNode removekeys(TreeNode root, int l, int r) {
        // code here
        return util(root, l, r);
    }

    private TreeNode util(TreeNode root, int min, int max){
        if(root== null)
            return root;

        root.left = util(root.left, min, max);
        root.right = util(root.right, min, max);

        if(root.val<min){
            TreeNode right = root.right;
            root =null;
            return right;
        }

        if(root.val>max){
            TreeNode left = root.left;
            root =null;
            return left;
        }

        return root;
    }
}
