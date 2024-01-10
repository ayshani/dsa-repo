package com.tree;
/*
2385. Amount of Time for Binary Tree to Be Infected

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts
from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

Example 1:
Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.

TC : o(n)
SC: o(n)
 */
public class AmountOfTimeForBinaryTreeToBeInfected {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        System.out.println(new AmountOfTimeForBinaryTreeToBeInfected().amountOfTime(root,3));
    }
    int maxDistance =0;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root,start);
        return maxDistance;
    }

    public int dfs(TreeNode root,int start){
        int depth =0;
        if(root==null)
            return 0;

        int leftDepth = dfs(root.left, start);
        int rightDepth = dfs(root.right, start);

        if(root.val == start){
            maxDistance = Math.max(leftDepth, rightDepth);
            depth =-1;
        } else if(leftDepth >=0 && rightDepth>=0){
            depth = Math.max(leftDepth, rightDepth) +1;
        } else{
            int distance = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, distance);
            depth = Math.min(leftDepth, rightDepth) -1;
        }
        return depth;
    }
}
