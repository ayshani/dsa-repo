package com.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversalIterative(root));
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

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode previous = null;

        while(!st.isEmpty() || root!= null){
            if(root!=null){
                st.push(root);
                root = root.left;
            } else{
                root = st.peek();
                if(root.right == null || root.right == previous){
                    ans.add(root.val);
                    st.pop();
                    previous = root;
                    root = null;
                } else{
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
