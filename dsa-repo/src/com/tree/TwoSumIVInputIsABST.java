package com.tree;

import java.util.HashMap;
import java.util.Map;

/*
653. Two Sum IV - Input is a BST

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in
the BST such that their sum is equal to the given target.

Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
                     5
                3        6
             2    4   N     7
Output: true

TC : o(n)
SC : o(n)
 */
public class TwoSumIVInputIsABST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(new TwoSumIVInputIsABST().findTarget(root,9));

    }
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        inorder(root,map);

        for(int num : map.keySet()){
            if((num*2 == k && map.get(num)>1) || (num*2!=k && map.containsKey(k-num)))
                return true;
        }

        return false;
    }

    private void inorder(TreeNode root, Map<Integer,Integer> map){
        if(root==null)
            return;
        inorder(root.left, map);

        map.put(root.val, map.getOrDefault(root.val,0)+1);
        inorder(root.right,map);
    }
}
