package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
116. Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node,
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example 1:

Input: root = [1,2,3,4,5,6,7]
            1
         2      3
      4    5  6    7
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A),
your function should populate each next pointer to point to its next right node, just like in Figure B.
The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class PopulatingNextRightPointersInEachNode {

    public static void main(String[] args) {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left =  new TNode(4);
        root.left.right = new TNode(5);
        root.right.left =  new TNode(6);
        root.right.right = new TNode(7);
        PopulatingNextRightPointersInEachNode obj = new PopulatingNextRightPointersInEachNode();
        obj.connect(root);
        new TreeTraversal().printTreeByNextNode(root);

    }
    public TNode connect(TNode root) {
        if(root==null)
            return root;
        Queue<TNode> q = new LinkedList<>();
        q.offer(root);

        TNode prev = null;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TNode cur = q.poll();

                if(i==0){
                    prev = cur;
                } else{
                    prev.next = cur;
                    prev =cur;
                }

                if(cur.left!=null)
                    q.offer(cur.left);
                if(cur.right!=null)
                    q.offer(cur.right);
            }

            prev.next = null;
        }

        return root;
    }
}

class TNode{
    int val;
    TNode left,right,next;
    public TNode(int v){
        this.val = v;
        left = null;
        right = null;
        next = null;
    }
}
