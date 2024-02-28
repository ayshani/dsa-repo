package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
513. Find Bottom Left Tree Value
Given the root of a binary tree, return the leftmost value in the last row of the tree.



Example 1:
Input: root = [2,1,3]
Output: 1

TC : o(n)
SC: o(n)
 */
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(root));
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int value =0;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                if(i==0){
                    value = cur.val;
                }
                if(null != cur.left){
                    q.offer(cur.left);
                }
                if(null != cur.right){
                    q.offer(cur.right);
                }
            }
        }
        return value;
    }
}
