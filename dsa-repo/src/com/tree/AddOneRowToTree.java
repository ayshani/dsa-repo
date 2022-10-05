package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
623. Add One Row to Tree

Given the root of a binary tree and two integers val and depth, add a row of nodes with value val
at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1,
create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val
as the new root of the whole original tree, and the original tree is the new root's left subtree.

Example 1:
Input: root = [4,2,6,3,1,5], val = 1, depth = 2
                4
             2     6
           3   1  5

              ||

              4
           1     1
         2          6
       3   1      5
Output: [4,1,1,2,null,null,6,3,1,5]

Time complexity : O(n). A total of nn nodes of the given tree will be considered in the worst case.

Space complexity : O(x). The size of the queue or temp queue can grow upto x only.
                   Here, x refers to the number of maximum number of nodes at any level in the given tree.
 */
public class AddOneRowToTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);

        TreeNode res = new AddOneRowToTree().addOneRow(root,1,3);
        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // if depth==1 then add new row to the root
        if(depth==1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int d =1;
        // iterate until d s one less than actual depth where change needs to be done
        // point the queue q to that d-1th level
        while(d<depth-1){
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(node.left!=null)
                    temp.add(node.left);
                if(node.right!=null)
                    temp.add(node.right);
            }
            q = temp;
            d++;
        }

        // add the new row
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }

        return root;
    }
}
