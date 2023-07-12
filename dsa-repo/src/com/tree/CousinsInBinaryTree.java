package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
993. Cousins in Binary Tree

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
        1
      2    3
    4
Output: false

TC : o(n)
SC : o(n)
 */
public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(new CousinsInBinaryTree().isCousins(root,4,3));
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        boolean foundX = false, foundY = false;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            foundX = false;
            foundY = false;
            while(size-->0){
                TreeNode current = q.poll();
                if(current.val == x)
                    foundX = true;
                if(current.val == y)
                    foundY = true;

                if(current.left!= null && current.right!=null){
                    if((current.left.val==x  && current.right.val == y)
                            ||(current.left.val==y  && current.right.val == x))
                        return false;
                }

                if(current.left!= null)
                    q.offer(current.left);
                if(current.right!= null)
                    q.offer(current.right);
            }

            if(foundX && foundY)
                return true;
            else if(foundX || foundY)
                return false;
        }

        return false;
    }
}
