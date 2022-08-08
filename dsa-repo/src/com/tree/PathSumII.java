package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
113. Path Sum II
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
                    5
                 4      8
             11       13    4
          7     2         5    1

Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

Logic
------
use backtracking logic.
base case is : if we are on the leaf node and it is = target sum, add it in result and
if not, then traverse left and rigth sub tree and decrement tragetSum by its root value.

TC : o(n)
SC : o(n)
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        pathSum(root, targetSum, result, new LinkedList<Integer>());
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, LinkedList<Integer> currSum){
        if(root==null)
            return;
        currSum.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            result.add( new ArrayList<Integer>(currSum));
            currSum.remove(currSum.size()-1);
            return;
        }

        pathSum(root.left, targetSum - root.val, result,currSum);
        pathSum(root.right, targetSum - root.val, result,currSum);
        currSum.remove(currSum.size()-1);
    }
}
