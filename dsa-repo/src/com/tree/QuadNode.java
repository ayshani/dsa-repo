package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class QuadNode {
    // Definition for a QuadTree node
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;


    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public static void print(QuadNode root){
        Queue<QuadNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            QuadNode cur = q.poll();
            System.out.println(cur.isLeaf + " " + cur.val);
            if(cur.topLeft!=null){
                q.offer(cur.topLeft);
            }
            if(cur.topRight!=null){
                q.offer(cur.topRight);
            }
            if(cur.bottomLeft!=null){
                q.offer(cur.bottomLeft);
            }
            if(cur.bottomRight!=null){
                q.offer(cur.bottomRight);
            }
        }
    }
}
