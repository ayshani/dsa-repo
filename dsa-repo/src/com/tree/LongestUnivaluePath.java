package com.tree;
/*
687. Longest Univalue Path

Given the root of a binary tree, return the length of the longest path, where each node in the
path has the same value. This path may or may not pass through the root.

The length of the path between two nodes is represented by the number of edges between them.

Example 1:Input: root = [5,4,5,1,1,null,5]
            5
         4     5
       1    1     5
Output: 2
Explanation: The shown image shows that the longest path of the same value (i.e. 5).

Intuition

We can think of any path (of nodes with the same values) as up to two arrows extending from it's root.
Specifically, the root of a path will be the unique node such that the parent of that node does not
appear in the path, and an arrow will be a path where the root only has one child node in the path.
Then, for each node, we want to know what is the longest possible arrow extending left, and the longest
possible arrow extending right? We can solve this using recursion.

Algorithm
-------------
Let arrow_length(node) be the length of the longest arrow that extends from the node.
That will be 1 + arrow_length(node.left) if node.left exists and has the same value as node.
Similarly for the node.right case.

While we are computing arrow lengths, each candidate answer will be the sum of the arrows in both directions
from that node. We record these candidate answers and return the best one.


TC : o(n)
SC:  o(h)

 */
public class LongestUnivaluePath {
    int count;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }
    public int longestUnivaluePath(TreeNode root) {
        count =0;
        length(root);
        return count;
    }

    private int length(TreeNode node){
        if(node==null)
            return 0;
        int left = length(node.left);
        int right = length(node.right);
        int arrowLeft =0, arrowRight =0;
        if(node.left!=null && node.left.val==node.val){
            arrowLeft = left+1;
        }
        if(node.right!=null && node.right.val==node.val){
            arrowRight = right+1;
        }

        count = Math.max(count, arrowLeft+arrowRight);

        return Math.max(arrowRight,arrowLeft);

    }
}
