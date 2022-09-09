package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
559. Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
              1
         3    2    4
       5   6

Output: 3

TC : o(n)
SC : o(n)
 */
public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        List<Node> childrenOf3 = new ArrayList<>();
        childrenOf3.add(new Node(5));
        childrenOf3.add(new Node(6));

        List<Node> childrenOfRoot = new ArrayList<>();
        childrenOfRoot.add(new Node(3,childrenOf3));
        childrenOfRoot.add(new Node(2));
        childrenOfRoot.add(new Node(4));

        Node root = new Node(1,childrenOfRoot);

        System.out.println(new MaximumDepthOfNAryTree().maxDepth(root));
    }
    public int maxDepth(Node root) {
        int depth=0;
        if(root==null)
            return depth;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            while(size-->0){
                Node current = q.poll();
                if(current.children!=null){
                    for(Node child : current.children){
                        q.offer(child);
                    }
                }
            }
        }
        return depth;
    }
}
