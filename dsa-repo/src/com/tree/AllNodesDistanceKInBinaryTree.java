package com.tree;

import java.util.*;

/*
863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k,
return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
                3
            5        1
         6     2   0     8
            7     4
Alogo
-----
find child parent relationship.
first try to get all childs from the target
then find the parent of target and reduce by 1 each time a parent is found .
    then go and find children at the reduced level from each parent
TC : o(k*k)
SC: o(n)
 */
public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> childParent;
    List<Integer> result;
    Set<TreeNode> visited;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(22);
        root.left.right = new TreeNode(5);
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root,root.right,2));
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        childParent = new HashMap<>();
        result = new ArrayList<>();
        visited = new HashSet<>();
        // crete child parent relationship
        dfs(root, target, null);
        // straight away get descends from target
        drill(target,k);
        int temp = k;

        // iterate through each parent and reduce a level .
        // get descends that are at reduced level .
        while(temp>=0){
            TreeNode node = childParent.get(target);
            if(node==null)
                break;

            drill(node, temp-1);
            temp--;
            target = node;
        }
        return result;
    }

    private void dfs(TreeNode root, TreeNode target, TreeNode parent){
        if(root==null)
            return;
        childParent.put(root,parent);
        if(root==target){
            return;
        }
        dfs(root.left,target,root);
        dfs(root.right,target,root);
    }

    private void drill(TreeNode node, int k){
        if(node != null && !visited.contains(node)){
            if(k==0){
                result.add(node.val);
                return;
            }
            visited.add(node);
            drill(node.left, k-1);
            drill(node.right, k-1);
        }
    }
}
