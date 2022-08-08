package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public void printTreeLevelOrder(TreeNode root){
        if(root==null)
            return;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if(node.left!=null)
                q.offer(node.left);
            if(node.right!=null)
                q.offer(node.right);
        }
    }
}
