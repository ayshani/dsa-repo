package com.tree;
/*
129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.
Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Input: root = [1,2,3]
        1
     2      3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.


TC : o(n)
SC : o(logn)
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root, int s){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return s*10+ root.val;
        }
        return helper(root.left, s*10 + root.val) + helper(root.right, s*10+root.val);
    }
}
