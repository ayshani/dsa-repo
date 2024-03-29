package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
95. Unique Binary Search Trees II

Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of
unique values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

TC : o(4^n)
SC: o(n)
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        List<TreeNode> list = new UniqueBinarySearchTreesII().generateTrees(3);
        list.stream().forEach(root -> {
                                new TreeTraversal().printTreeLevelOrder(root);
                                System.out.println();
                                    });
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return build(1,n);
    }

    private List<TreeNode> build(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i= start;i<=end;i++){
            List<TreeNode> leftSubtree = build(start, i-1);
            List<TreeNode> rightSubtree = build(i+1, end);
            for(TreeNode leftTree : leftSubtree){
                for(TreeNode rightTree : rightSubtree){
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
