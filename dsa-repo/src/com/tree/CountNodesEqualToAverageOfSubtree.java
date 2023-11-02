package com.tree;

/*
2265. Count Nodes Equal to Average of Subtree

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of
the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.

Example 1:
Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation:
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.

TC : o(n)
SC: o(logn)
 */
public class CountNodesEqualToAverageOfSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(root));
    }
    int globalCount;
    public int averageOfSubtree(TreeNode root) {
        globalCount =0;
        dfs(root);
        return globalCount;
    }

    public SubtreePair dfs(TreeNode root){
        if(root==null)
            return new SubtreePair(0,0);
        if(root.left==null && root.right==null){
            globalCount++;
            return new SubtreePair(root.val,1);
        }
        SubtreePair left = dfs(root.left);
        SubtreePair right = dfs(root.right);

        int totalSum = root.val + left.sum + right.sum;
        int totalCount = 1 + left.count + right.count;

        if((totalSum/totalCount) == root.val){
            globalCount++;
        }
        return new SubtreePair(totalSum, totalCount);
    }
}
class SubtreePair{
    int sum, count;
    public SubtreePair(int x, int y){
        this.sum = x;
        this.count =y;
    }
}
