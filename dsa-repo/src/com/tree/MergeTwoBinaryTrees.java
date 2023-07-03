package com.tree;
/*
617. Merge Two Binary Trees

You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the
others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node
of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

TC : o(n)
SC: o(logn)

 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left =  new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(10);
        root1.left.left = new TreeNode(1);
        root1.left.right =  new TreeNode(6);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right =  new TreeNode(7);

        System.out.println(new BinaryTreeInorderTraversal().
                inorderTraversal(new MergeTwoBinaryTrees().mergeTrees(root,root1)));
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }

    private TreeNode merge(TreeNode root1,TreeNode root2){
        if(root1== null && root2==null){
            return null;
        }
        TreeNode root = null;
        if(root1!=null && root2==null){
            root = new TreeNode(root1.val);
            root.left = root1.left;
            root.right = root1.right;
        } else if(root1==null && root2!=null){
            root = new TreeNode(root2.val);
            root.left = root2.left;
            root.right = root2.right;
        } else{
            root = new TreeNode(root1.val+ root2.val);
            root.left = merge(root1.left, root2.left);
            root.right = merge(root1.right, root2.right);
        }

        return root;
    }
}
