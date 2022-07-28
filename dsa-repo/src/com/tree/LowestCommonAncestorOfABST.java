package com.tree;
/*
 * 235 . Lowest Common Ancestor of a Binary Search Tree
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 *
 * According to the definition of LCA on Wikipedia: �The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).�
 *
 *  		6
 * 		2		 8
 *   0	  4    7   9
 *      3   5
 *
 * p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * TC : O(N)
 * SC : O(1)
 */
public class LowestCommonAncestorOfABST {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right =  new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right =  new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        LowestCommonAncestorOfABST obj = new LowestCommonAncestorOfABST();
        System.out.println(obj.lowestCommonAncestor(root, root.left, root.right).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }

}

