package com.tree;
/*
951. Flip Equivalent Binary Trees

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child
subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of
flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false
otherwise.



Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.

TC : o(n)
SC: o(n)
 */
public class FlipEquivalentBinaryTrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println(new FlipEquivalentBinaryTrees().flipEquiv(root,root2));
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        findCanonicalForm(root1);
        findCanonicalForm(root2);
        return areEquivalent(root1, root2);
    }

    public boolean areEquivalent(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return (
                areEquivalent(root1.left, root2.left) &&
                        areEquivalent(root1.right, root2.right)
        );
    }

    public void findCanonicalForm(TreeNode root) {
        if (root == null) return;

        // Post-order traversal: first bring subtrees into their canonical form
        findCanonicalForm(root.left);
        findCanonicalForm(root.right);

        if (root.right == null) return;

        // Swap subtrees, so that left is non-empty
        if (root.left == null) {
            root.left = root.right;
            root.right = null;
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        // Swap subtrees
        if (left.val > right.val) {
            root.left = right;
            root.right = left;
        }
    }
}
