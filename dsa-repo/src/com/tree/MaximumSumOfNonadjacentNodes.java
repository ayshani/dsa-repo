package com.tree;
/*
Maximum sum of Non-adjacent nodes
https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1

Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that
sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected
that is, if we have taken a node in our sum then we can’t take its any children or parents in consideration and
vice versa.

Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.

TC : o(n)
SC: o(logn)
 */
public class MaximumSumOfNonadjacentNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        System.out.println(MaximumSumOfNonadjacentNodes.getMaxSum(root));
    }
    static int getMaxSum(TreeNode root)
    {
        // add your code here
        Pair pair = solve(root);
        return Math.max(pair.first, pair.second);
    }

    static Pair solve(TreeNode root){
        if(root==null)
            return new Pair(0,0);
        Pair cur = new Pair(0,0);

        Pair left = solve(root.left);
        Pair right = solve(root.right);
        cur.first = root.val + left.second + right.second;
        cur.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        return cur;
    }
}

class Pair{
    int first, second;
    public Pair(int f, int s){
        this.first =f;
        this.second = s;
    }
}
