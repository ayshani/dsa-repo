package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.
Example 1:
Input: root = [1,2,3,null,5]
        1
      2    3
        5

Output: ["1->2->5","1->3"]

TC : o(n)
SC : o(n)
 */
public class  BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        paths(root, result, new StringBuilder());

        return result;
    }

    private void paths(TreeNode root, List<String> result, StringBuilder sb){
        if(root==null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right == null){
            result.add(String.valueOf(sb));

        } else{
            sb.append("->");
            paths(root.left,result,sb);
            paths(root.right, result,sb);
        }
        sb.setLength(len);
    }
}
