package com.design;

import com.tree.TreeNode;

import java.util.HashSet;

/*
1261. Find Elements in a Contaminated Binary Tree

Given a binary tree with the following rules:

root.val == 0
For any treeNode:
If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

Implement the FindElements class:

FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
bool find(int target) Returns true if the target value exists in the recovered binary tree.

Example 1:


Input
["FindElements","find","find"]
[[[-1,null,-1]],[1],[2]]
Output
[null,false,true]
Explanation
FindElements findElements = new FindElements([-1,null,-1]);
findElements.find(1); // return False
findElements.find(2); // return True

TC : o(n)
SC: o(n)
 */
public class FindElementsInAContaminatedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);

        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(1)); // return False
        System.out.println(findElements.find(2)); // return True

    }
}

class FindElements {

    HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }

    private void dfs(TreeNode currentNode, int currentValue) {
        if (currentNode == null) return;
        // visit current node by adding its value to seen
        seen.add(currentValue);
        dfs(currentNode.left, currentValue * 2 + 1);
        dfs(currentNode.right, currentValue * 2 + 2);
    }
}
