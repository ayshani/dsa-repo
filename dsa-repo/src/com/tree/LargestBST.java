package com.tree;
/*
Largest BST
https://practice.geeksforgeeks.org/problems/largest-bst/1

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

Example 1:

Input:
        1
      /   \
     4     4
   /   \
  6     8
Output: 1
Explanation: There's no sub-tree with size
greater than 1 which forms a BST. All the
leaf Nodes are the BSTs with size equal
to 1.

TC : o(n)
SC: o(logn)
 */
public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);

        System.out.println(LargestBST.largestBst(root));
    }
    static int largestBst(TreeNode root)
    {
        // Write your code here
        return util(root).size;

    }

    static NodeInfo util(TreeNode root){
        if(root==null){
            return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE,true);
        }

        NodeInfo left = util(root.left);
        NodeInfo right = util(root.right);

        NodeInfo cur = new NodeInfo();
        cur.min = Math.min(root.val, left.min);
        cur.max = Math.max(root.val, right.max);
        cur.isBST = left.isBST && right.isBST && root.val> left.max && root.val < right.min;

        if(cur.isBST){
            cur.size = left.size+right.size+1;
        } else{
            cur.size = Math.max(left.size , right.size);
        }
        return cur;
    }

}
class NodeInfo{
    int min,max, size;
    boolean isBST;

    public NodeInfo(){

    }
    public NodeInfo(int size, int min, int max, boolean isBST){
        this.size=size;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }


}
