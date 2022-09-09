package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: root = [3,9,20,null,null,15,7]
        3
     9     20
         15    7

Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Time complexity : O(n).
The whole tree is traversed atmost once. Here, nn refers to the number of nodes in the given binary tree.

Space complexity : O(m).
The size of queuequeue or temptemp can grow upto atmost the maximum number of nodes
at any level in the given binary tree. Here, mm refers to the maximum mumber of nodes at any level in the input tree.
 */
public class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(root));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            int total = size;
            double sum =0;
            while(size-->0){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left != null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }

            double avg = sum/total;
            result.add(avg);
        }

        return result;

    }
}
