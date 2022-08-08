package com.tree;

import java.util.HashMap;
import java.util.Map;

/*
2196. Create Binary Tree From Descriptions

You are given a 2D integer array descriptions where descriptions[i] =
[parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values.
Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:
Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

TC : o(n)
SC : o(n)
 */
public class CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {
        int[][] descriptions = new int[][]{
                {20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}
        };
        TreeNode root = new CreateBinaryTreeFromDescriptions().createBinaryTree(descriptions);

        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root = null;

        Map<Integer, TreeNode> map = new HashMap<>();

        for(int[] des : descriptions){
            map.put(des[1],new TreeNode(des[1]));
        }

        for(int[] des : descriptions){
            if(!map.containsKey(des[0])){
                root = new TreeNode(des[0]);
                map.put(des[0],root);
            }

            TreeNode parent = map.get(des[0]);
            TreeNode child = map.get(des[1]);

            if(des[2]==1)
                parent.left = child;
            else
                parent.right = child;
        }

        return root;
    }
}
