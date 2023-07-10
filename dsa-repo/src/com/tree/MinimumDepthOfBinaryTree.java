package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

TC: o(n)
SC: o(max width length)
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int level=1;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode tmp = q.poll();
                if(tmp.left==null && tmp.right==null){
                    //System.out.println(level);
                    return level;
                }
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            level++;
        }

        return level;
    }
}
