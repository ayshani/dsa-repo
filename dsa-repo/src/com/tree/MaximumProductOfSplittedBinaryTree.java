package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
1339. Maximum Product of Splitted Binary Tree

Given the root of a binary tree, split the binary tree into two subtrees by removing one edge
such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large,
return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.

Example 1:
Input: root = [1,2,3,4,5,6]
                1
             2     3
          4    5  6
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)

TC : o(n)
SC : o(n)
 */
public class MaximumProductOfSplittedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(new MaximumProductOfSplittedBinaryTree().maxProduct(root));
    }
    private List<Long> list;
    int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        list = new ArrayList<>();
        long total = postOrder(root);
        long prod =0, max =0;

        for(int i=0;i<list.size()-1;i++){
            prod = list.get(i) * (total-list.get(i));
            max = Math.max(prod,max);
        }
        return (int)(max%mod);
    }

    private long postOrder(TreeNode root){
        if(root==null)
            return 0;

        long left = postOrder(root.left);
        long right = postOrder(root.right);

        long cur = left+ right + root.val;

        list.add(cur);
        return cur;
    }
}
