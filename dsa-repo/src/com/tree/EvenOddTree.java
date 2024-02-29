package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
1609. Even Odd Tree

A binary tree is named Even-Odd if it meets the following conditions:

The root of the binary tree is at level index 0, its children are at level index 1, their children are at
level index 2, etc.
For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order
(from left to right).
For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order
(from left to right).
Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.



Example 1:
Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
Output: true
Explanation: The node values on each level are:
Level 0: [1]
Level 1: [10,4]
Level 2: [3,7,9]
Level 3: [12,8,6,2]
Since levels 0 and 2 are all odd and increasing and levels 1 and 3 are all even and decreasing, the tree is
Even-Odd.

TC : o(n)
SC : o(max width of tree)
 */
public class EvenOddTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);

        System.out.println(new EvenOddTree().isEvenOddTree(root));
    }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level%2==0){
                int prevVal = Integer.MIN_VALUE;
                for(int i=0;i<size;i++){
                    TreeNode cur = q.poll();
                    if(cur.val%2==0 || prevVal >= cur.val){
                        return false;
                    }
                    prevVal = cur.val;
                    if(cur.left!=null){
                        q.offer(cur.left);
                    }
                    if(cur.right!=null){
                        q.offer(cur.right);
                    }
                }
            } else{
                int prevVal = Integer.MAX_VALUE;
                for(int i=0;i<size;i++){
                    TreeNode cur = q.poll();
                    if(cur.val%2==1 || prevVal <= cur.val){
                        return false;
                    }
                    prevVal = cur.val;
                    if(cur.left!=null){
                        q.offer(cur.left);
                    }
                    if(cur.right!=null){
                        q.offer(cur.right);
                    }
                }
            }
            level++;
        }
        return true;
    }
}
