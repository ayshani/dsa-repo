package com.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
501. Find Mode in Binary Search Tree

Given the root of a binary search tree (BST) with duplicates, return all the mode(s)
(i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,null,2,2]
        1
           2
         2
Output: [2]

TC : o(n)
SC : o(n)
 */
public class FindModeInBinarySearchTree {
    int maxCount =1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] res = new FindModeInBinarySearchTree().findMode(root);
        Arrays.stream(res).forEach(element -> System.out.print(element+" "));
    }
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();

        findMode(root,map);

        int[] result = new int[map.size()];
        int index =0;
        for(Integer num : map.keySet()){
            if(map.get(num)== maxCount){
                result[index++] = num;
            }
        }

        return Arrays.copyOf(result,index);
    }

    void findMode(TreeNode root, Map<Integer,Integer> map){
        if(root==null)
            return;

        map.put(root.val, map.getOrDefault(root.val,0)+1);
        maxCount = Math.max(maxCount,map.get(root.val));

        findMode(root.left,map);
        findMode(root.right,map);
    }
}
