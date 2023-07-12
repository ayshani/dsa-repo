package com.tree;

import java.util.*;

/*
652. Find Duplicate Subtrees

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.



Example 1:
Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]

TC : o(n)
SC: o(n)
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        new FindDuplicateSubtrees().findDuplicateSubtrees(root)
                .forEach(node -> {new TreeTraversal().printTreeLevelOrder(node);
                                  System.out.println();});
    }
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        util(root, map,set);
        List<TreeNode> res = new ArrayList<>(set);
//        for(TreeNode node : set){
//            res.add(node);
//        }
        return res;
    }

    private String util(TreeNode root, HashMap<String, TreeNode> map, Set<TreeNode> set){
        if(root==null)
            return "null";

        String s = "";
        s += root.val+"";
        s+= "left<" + util(root.left,map,set) +">";
        s+= "right<" + util(root.right,map,set) +">";

        if(!map.containsKey(s)){
            map.put(s,root);
        } else{
            set.add(map.get(s));
        }
        return s;
    }
}
