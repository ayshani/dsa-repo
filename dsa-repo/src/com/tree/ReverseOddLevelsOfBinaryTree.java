package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
2415. Reverse Odd Levels of Binary Tree

Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
Return the root of the reversed tree.

A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

The level of a node is the number of edges along the path between it and the root node.



Example 1:
Input: root = [2,3,5,8,13,21,34]
Output: [2,5,3,8,13,21,34]
Explanation:
The tree has only one odd level.
The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.

TC : o(n)
SC: o(n)
 */
public class ReverseOddLevelsOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);
        root = new ReverseOddLevelsOfBinaryTree().reverseOddLevels(root);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();
            for(int i=0;i<size; i++){
                TreeNode node = queue.poll();
                currentLevel.add(node);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            if(level % 2 == 1){
                int left =0, right = currentLevel.size()-1;
                while(left < right){
                    int temp = currentLevel.get(left).val;
                    currentLevel.get(left).val = currentLevel.get(right).val;
                    currentLevel.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;

        }
        return root;
    }
}
