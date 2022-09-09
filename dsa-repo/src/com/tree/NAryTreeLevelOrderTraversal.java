package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal,
each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
              1
         3    2    4
       5   6
Output: [[1],[3,2,4],[5,6]]

TC : o(n)
SC : o(n)
 */
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {

        List<Node> childrenOf3 = new ArrayList<>();
        childrenOf3.add(new Node(5));
        childrenOf3.add(new Node(6));

        List<Node> childrenOfRoot = new ArrayList<>();
        childrenOfRoot.add(new Node(3,childrenOf3));
        childrenOfRoot.add(new Node(2));
        childrenOfRoot.add(new Node(4));

        Node root = new Node(1,childrenOfRoot);

        System.out.println(new NAryTreeLevelOrderTraversal().levelOrder(root));
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                Node current = q.poll();
                list.add(current.val);
                if(current.children != null) {
                    for (Node child : current.children) {
                        q.offer(child);
                    }
                }
            }
            if(!list.isEmpty()){
                result.add(list);
            }
        }

        return result;
    }
}

