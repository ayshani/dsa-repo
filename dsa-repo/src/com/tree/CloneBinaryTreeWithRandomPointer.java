package com.tree;

import java.util.HashMap;
import java.util.Map;

/*
1485. Clone Binary Tree With Random Pointer

A binary tree is given such that each node contains an additional random pointer which could point to any node in
the tree or null.

Return a deep copy of the tree.

The tree is represented in the same input/output way as normal binary trees where each node is represented as
a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point
to any node.
You will be given the tree in class Node and you should return the cloned tree in class NodeCopy. NodeCopy class is
just a clone of Node class with the same attributes and constructors.

Example 1:
Input: root = [[1,null],null,[4,3],[7,0]]
Output: [[1,null],null,[4,3],[7,0]]
Explanation: The original binary tree is [1,null,4,7].
The random pointer of node one is null, so it is represented as [1, null].
The random pointer of node 4 is node 7, so it is represented as [4, 3] where 3 is the index of node 7 in the
    array representing the tree.
The random pointer of node 7 is node 1, so it is represented as [7, 0] where 0 is the index of node 1 in the
    array representing the tree.


TC : o(n)
SC: o(n)
 */
public class CloneBinaryTreeWithRandomPointer {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = new TreeNode(5);
        root.right.random = root;

        NodeCopy newRoot = new CloneBinaryTreeWithRandomPointer().copyRandomBinaryTree(root);
        new TreeTraversal().printTreeLevelOrder(root);

    }
    Map<TreeNode, NodeCopy> map;
    public NodeCopy copyRandomBinaryTree(TreeNode root) {
        map = new HashMap<>();
        NodeCopy newRoot = solve(root);
        return newRoot;
    }

    private NodeCopy solve(TreeNode root){
        if(root==null)
            return null;
        if(map.containsKey(root))
            return map.get(root);

        NodeCopy newRoot = new NodeCopy(root.val);
        map.put(root,newRoot);
        newRoot.left = solve(root.left);
        newRoot.right = solve(root.right);
        newRoot.random = solve(root.random);
        return newRoot;
    }
}

class NodeCopy{
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;
    NodeCopy() {}
    NodeCopy(int val) { this.val = val; }
    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }

    @Override
    public String toString() {
        return "NodeCopy{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", random=" + random +
                '}';
    }
}
