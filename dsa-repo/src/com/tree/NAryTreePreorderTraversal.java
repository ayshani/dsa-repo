package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
589. N-ary Tree Preorder Traversal

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal.
Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
                  1
              3   2   4
            5   6
Output: [1,3,5,6,2,4]

TC : o(n)
SC : o(n)
 */
public class NAryTreePreorderTraversal {

    public static void main(String[] args) {
        List<Node> childrenOf3 = new ArrayList<>();
        childrenOf3.add(new Node(5));
        childrenOf3.add(new Node(6));

        List<Node> childrenOfRoot = new ArrayList<>();
        childrenOfRoot.add(new Node(3,childrenOf3));
        childrenOfRoot.add(new Node(2));
        childrenOfRoot.add(new Node(4));

        Node root = new Node(1,childrenOfRoot);
        System.out.println(new NAryTreePreorderTraversal().preorder(root));
    }
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        util(root, result);
        return result;
    }

    private void util(Node root, List<Integer> result){
        if(root==null)
            return ;

        result.add(root.val);
        if(root.children!=null) {
            for (Node child : root.children) {
                util(child, result);
            }
        }
    }
}
