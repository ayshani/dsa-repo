package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
872. Leaf-Similar Trees

Consider all the leaves of a binary tree, from left to right order,
the values of those leaves form a leaf value sequence.

                3
            5       1
        6     2    9  8
            7   4

 For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

TC : o(n)
SC : o(No. of leaf nodes)
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(new LeafSimilarTrees().leafSimilar(root1,root2));

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>(), tree2 = new ArrayList<>();

        traverse(root1,tree1);
        traverse(root2,tree2);

        if(tree1.size() != tree2.size())
            return false;
        for(int i=0;i<tree1.size();i++){
            if(tree1.get(i)!=tree2.get(i))
                return false;
        }
        return true;
    }

    void traverse(TreeNode root, List<Integer> tree){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            tree.add(root.val);
        }
        traverse(root.left,tree);
        traverse(root.right,tree);
    }
}
