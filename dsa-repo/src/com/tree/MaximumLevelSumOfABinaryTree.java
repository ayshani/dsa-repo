package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
1161. Maximum Level Sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.



Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

TC : o(n)
SC: o(max children per level)
 */
public class MaximumLevelSumOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right =  new TreeNode(-8);
        root.right.left = null;
        root.right.right = null;

        System.out.println(new MaximumLevelSumOfABinaryTree().maxLevelSum(root));
    }
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int minLevel =0, level=1, sum =Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int curSum =0;
            while(size-->0){
                TreeNode cur = q.poll();
                curSum += cur.val;
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            if(curSum>sum){
                sum = curSum;
                minLevel = level;
            }
            level++;
        }
        return minLevel;
    }
}
