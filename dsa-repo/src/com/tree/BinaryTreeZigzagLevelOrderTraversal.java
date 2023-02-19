package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

TC: o(n)
SC: o(n)
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    List<List<Integer>> result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();

        if(root==null)
            return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> res1 = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode cur = s1.pop();
                res1.add(cur.val);
                if(cur.left!=null)
                    s2.push(cur.left);
                if(cur.right!=null)
                    s2.push(cur.right);
            }
            if(!res1.isEmpty())
                result.add(res1);
            ArrayList<Integer> res2 = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode cur = s2.pop();
                res2.add(cur.val);
                if(cur.right!=null)
                    s1.push(cur.right);
                if(cur.left!=null)
                    s1.push(cur.left);

            }

            if(!res2.isEmpty())
                result.add(res2);
        }

        return result;
    }
}
