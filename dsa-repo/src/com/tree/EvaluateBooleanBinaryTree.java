package com.tree;
/*
2331. Evaluate Boolean Binary Tree

You are given the root of a full binary tree with the following properties:

Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
The evaluation of a node is as follows:

If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
Return the boolean result of evaluating the root node.

A full binary tree is a binary tree where each node has either 0 or 2 children.

A leaf node is a node that has zero children.

Example 1:
Input: root = [2,1,3,null,null,0,1]
                  or                             or                           true
          true         and          ->      true        false      ->
                 false     true
Output: true
Explanation: The above diagram illustrates the evaluation process.
The AND node evaluates to False AND True = False.
The OR node evaluates to True OR False = True.
The root node evaluates to True, so we return true.

TC : o(n)
SC : o(logn)
 */
public class EvaluateBooleanBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(new EvaluateBooleanBinaryTree().evaluateTree(root));
    }
    public boolean evaluateTree(TreeNode root) {
        if(root==null)
            return false;

        if(root.left==null && root.right==null)
            return root.val != 0;

        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);

        boolean result = false;
        if(root.val == 2)
            result = leftValue | rightValue;
        else
            result = leftValue & rightValue;

        return result;
    }
}
