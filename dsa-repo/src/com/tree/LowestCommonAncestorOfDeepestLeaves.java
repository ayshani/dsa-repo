package com.tree;
/*
1123. Lowest Common Ancestor of Deepest Leaves

Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.


Example 1:Input: root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2, colored in yellow in the diagram.
The nodes coloured in blue are the deepest leaf-nodes of the tree.
Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.

TC : o(n)
SC: o(logn)
 */
public class LowestCommonAncestorOfDeepestLeaves {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right =  new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right =  new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(root));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).key;
    }

    private TreePair dfs(TreeNode root) {
        if (root == null) {
            return new TreePair(null, 0);
        }

        TreePair left = dfs(root.left);
        TreePair right = dfs(root.right);

        if (left.value > right.value) {
            return new TreePair(left.key, left.value + 1);
        }
        if (left.value < right.value) {
            return new TreePair(right.key, right.value + 1);
        }
        return new TreePair(root, left.value + 1);
    }
}

class TreePair{
    TreeNode key;
    Integer value;

    public TreePair(TreeNode key, Integer value){
        this.key = key;
        this.value = value;
    }
}
