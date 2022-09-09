package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
662. Maximum Width of Binary Tree

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to
that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
             1
         3       2
      5    3        9
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).


Logic
----
The idea is to traverse all the node in the tree in level order(Here I use one Queue to store each level's nodes
with its index. The time I traverse each level is the queue's size(the number of nodes from upper level)).
Each time a node is traversed, the position of the node(as it is in a full binary tree) is stored in the queue.
If the position of the parent node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'.
The width of each level is the last node's position in this level subtracts the first node's position in
this level plus 1.

TC : o(n)
SC : o(n)
 */
public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(root));
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;

        Queue<MyNode> q = new LinkedList<>();
        q.offer(new MyNode(root,1));
        int currentWidth=0, maxWidth =0;

        while(!q.isEmpty()){
            int size =q.size();
            int start =0, end =0;
            for(int i=0;i<size;i++){
                MyNode currentNode = q.poll();
                int index = currentNode.index;
                TreeNode current = currentNode.node;
                if(i==0)
                    start = index;
                if(i==size-1)
                    end = index;

                if(current.left!=null){
                    q.offer(new MyNode(current.left, 2*index));
                }

                if(current.right!=null){
                    q.offer(new MyNode(current.right, 2*index+1));
                }
            }

            currentWidth = end - start +1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        return maxWidth;
    }

}

class MyNode{
    public TreeNode node;
    public int index;
    MyNode(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}