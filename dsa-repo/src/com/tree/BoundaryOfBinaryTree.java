package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
545. Boundary of Binary Tree

The boundary of a binary tree is the concatenation of the root, the left boundary, the leaves ordered from
left-to-right, and the reverse order of the right boundary.

The left boundary is the set of nodes defined by the following:

The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary
is empty.
If a node in the left boundary and has a left child, then the left child is in the left boundary.
If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left
boundary.
The leftmost leaf is not in the left boundary.
The right boundary is similar to the left boundary, except it is the right side of the root's right subtree.
Again, the leaf is not part of the right boundary, and the right boundary is empty if the root does not have a
right child.

The leaves are nodes that do not have any children. For this problem, the root is not a leaf.

Given the root of a binary tree, return the values of its boundary.

Example 1:
Input: root = [1,null,2,3,4]
Output: [1,3,4,2]
Explanation:
- The left boundary is empty because the root does not have a left child.
- The right boundary follows the path starting from the root's right child 2 -> 4.
  4 is a leaf, so the right boundary is [2].
- The leaves from left to right are [3,4].
Concatenating everything results in [1] + [] + [3,4] + [2] = [1,3,4,2].

TC : o(n)
SC: o(logn)
 */
public class BoundaryOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(root));
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null)
            return result;
        result.add(root.val);
        //traverse left
        TreeNode temp = root.left;
        traverseLeft(temp,result);

        // traverse leaf
        temp = root.left;
        traverseLeaf(temp,result);
        temp = root.right;
        traverseLeaf(temp,result);

        //traverse right
        temp = root.right;
        traverseRight(temp,result);

        return result;

    }

    private void traverseLeft(TreeNode root, List<Integer> result ){
        if(root==null || (root.left==null && root.right==null))
            return;
        result.add(root.val);
        if(root.left!=null)
            traverseLeft(root.left,result);
        else
            traverseLeft(root.right,result);
    }

    private void traverseRight(TreeNode root, List<Integer> result ){
        if(root==null || (root.left==null && root.right==null))
            return;

        if(root.right!=null)
            traverseRight(root.right,result);
        else
            traverseRight(root.left,result);
        result.add(root.val);
    }

    private void traverseLeaf(TreeNode root, List<Integer> result ){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            result.add(root.val);
            return;
        }
        traverseLeaf(root.left,result);
        traverseLeaf(root.right,result);
    }
}
