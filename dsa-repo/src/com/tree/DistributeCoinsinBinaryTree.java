package com.tree;
/*
979. Distribute Coins in Binary Tree

You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n
coins in total throughout the whole tree.

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent
to child, or from child to parent.

Return the minimum number of moves required to make every node have exactly one coin.

Example 1:
Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

TC : o(n)
SC: o(n)
 */
public class DistributeCoinsinBinaryTree {

    int moves;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);

        System.out.println(new DistributeCoinsinBinaryTree().distributeCoins(root));
    }
    public int distributeCoins(TreeNode root) {
        moves =0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftCoins = dfs(root.left);
        int rightCoins = dfs(root.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return (root.val -1) + leftCoins + rightCoins;
    }
}
