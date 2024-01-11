package com.tree;
/*
1026. Maximum Difference Between Node and Ancestor

Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Example 1:
Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
                     8
                3        10
             1     6         14
                 4   7    13
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Intuition

An insight is that:

Given any two nodes on the same root-to-leaf path, they must have the required ancestor relationship.
Therefore, we just need to record the maximum and minimum values of all root-to-leaf paths and return
the maximum difference.

To achieve this, we can record the maximum and minimum values during the recursion and
return the difference when encountering leaves.

Algorithm

Step 1: Define a function helper, which takes three arguments as input and returns an integer.

The first argument node is the current node, and the second argument cur_max and third argument cur_min
are the maximum and minimum values along the root to the current node, respectively.

Function helper returns cur_max - cur_min when encountering leaves.
Otherwise, it calls helper on the left and right subtrees and returns their maximum.

Step 2: Run helper on the root and return the result.

TC : o(n)
SC : o(n)

 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right =  new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right =  new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(new MaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(root));
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;

        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode root, int minVal, int maxVal){
        if(root==null)
            return maxVal - minVal;
        minVal = Math.min(minVal,root.val);
        maxVal = Math.max(maxVal,root.val);
        int left = helper(root.left,minVal,maxVal);
        int right = helper(root.right,minVal,maxVal);
        return Math.max(left,right);
    }
}
