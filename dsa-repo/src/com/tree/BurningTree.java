package com.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Burning Tree
https://practice.geeksforgeeks.org/problems/burning-tree/1
https://www.youtube.com/watch?v=2r5wLmQfD6g
https://leetcode.com/discuss/study-guide/1886481/minimum-time-taken-to-burn-the-binary-tree-from-a-node

Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.


Example 1:

Input:
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value
8 is set on fire.
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.

TC : o(n)
SC: o(n)
 */
public class BurningTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(10);

        System.out.println(BurningTree.minTime(root,8));

    }
    public static int minTime(TreeNode root, int target)
    {
        // Your code goes here
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        TreeNode targetNode = prepareMappingAndGetTargetNode(root, target,nodeToParentMap );
        return solve(root, targetNode, nodeToParentMap);
    }

    static TreeNode prepareMappingAndGetTargetNode(TreeNode root,int target,Map<TreeNode, TreeNode> map ){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        map.put(root,null);
        TreeNode targetNode = null;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.val == target){
                targetNode = cur;
            }

            if(cur.left!=null){
                map.put(cur.left, cur);
                q.offer(cur.left);
            }

            if(cur.right!=null){
                map.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
        return targetNode;
    }

    static int solve(TreeNode root, TreeNode targetNode, Map<TreeNode, TreeNode> nodeToParentMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(targetNode);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(targetNode,true);
        int time =0;
        while(!q.isEmpty()){
            int size= q.size();
            boolean isBurnt = false;
            while(size-->0){
                TreeNode cur = q.poll();
                if(cur.left!=null && !visited.getOrDefault(cur.left, false)){
                    isBurnt = true;
                    q.offer(cur.left);
                    visited.put(cur.left,true);
                }

                if(cur.right!=null && !visited.getOrDefault(cur.right, false)){
                    isBurnt = true;
                    q.offer(cur.right);
                    visited.put(cur.right,true);
                }
                if(nodeToParentMap.get(cur)!=null && !visited.getOrDefault(nodeToParentMap.get(cur), false)){
                    isBurnt = true;
                    q.offer(nodeToParentMap.get(cur));
                    visited.put(nodeToParentMap.get(cur),true);
                }

            }
            if(isBurnt)
                time++;
        }

        return time;
    }
}
