package com.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
1110. Delete Nodes And Return Forest

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.



Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

 */
public class DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        int[] toDelete = {1,10};
        System.out.println(new DeleteNodesAndReturnForest().delNodes(root,toDelete));
    }
    List<TreeNode> nodeList;
    Set<Integer> deleteSet;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        nodeList = new ArrayList<>();
        deleteSet = new HashSet<>();
        for(int num : to_delete){
            deleteSet.add(num);
        }

        util(root, true);
        return nodeList;
    }

    private TreeNode util(TreeNode root, boolean isRoot){
        if(root == null){
            return null;
        }
        boolean deleted = deleteSet.contains(root.val);
        if(isRoot && !deleted){
            nodeList.add(root);
        }

        root.left = util(root.left, deleted);
        root.right = util(root.right, deleted);
        return deleted ? null : root;
    }
}
