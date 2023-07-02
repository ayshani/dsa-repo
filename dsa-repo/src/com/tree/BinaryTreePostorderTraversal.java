package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
145. Binary Tree Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes' values.



Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

TC : o(n)
SC: o(n)
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        postOrder(root,result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {

        if(root== null)
            return;
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);

    }
}
