package com.tree;
/*
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * �The lowest common ancestor is defined between two nodes p and q as the lowest node in T that
 * has both p and q as descendants (where we allow a node to be a descendant of itself).�
 *
 * 			 3
 * 		5		 1
 *   6	  2    0   8
 *      7   4
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Logic
 * --------------------
 * If root is null or itself is one of the given two nodes, then this is itself a LCA.
 * If not we will go deep in root.left subtree and root.right subtree.
 * if we get left and right as non-empty, that means the root is LCA.
 * if one is empty then LCA hs to be another.
 *
 * TC : O(N)
 * SC : O(N)
 */
public class LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LowestCommonAncestorOfABinaryTree obj = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right =  new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right =  new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(obj.lowestCommonAncestor(root, root.left, root.left.right.right).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root== p || root== q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!= null && right!= null)
            return root;
        return left ==  null ? right :  left;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

