package com.graph.dfs;

import com.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
865. Smallest Subtree with all the Deepest Nodes

Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest nodes of the tree.
Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2 is the smallest subtree among them,
so we return it.

TC : o(N)
SC: o(n)
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(root));
    }
    Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth = new HashMap();
        depth.put(null, -1);
        dfs(root, null);
        max_depth = -1;
        for (Integer d: depth.values())
            max_depth = Math.max(max_depth, d);

        return answer(root);
    }

    private void dfs(TreeNode node, TreeNode parent){
        if(node != null){
            depth.put(node, depth.get(parent)+1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    private TreeNode answer(TreeNode node){
        if(node == null || depth.get(node) == max_depth){
            return node;
        }
        TreeNode L = answer(node.left), R = answer(node.right);
        if(L != null && R != null){
            return node;
        }
        if(L != null){
            return L;
        }
        if(R != null){
            return R;
        }
        return null;
    }
}
