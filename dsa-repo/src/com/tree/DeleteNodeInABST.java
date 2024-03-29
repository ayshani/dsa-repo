package com.tree;
/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node
reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.


Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

TC : o(logn)
SC: o(logn)
 */
public class DeleteNodeInABST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        new TreeTraversal().printTreeLevelOrder(new DeleteNodeInABST().deleteNode(root,2));
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key< root.val)
            root.left =  deleteNode(root.left, key);
        else if(key > root.val)
            root.right =  deleteNode(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            TreeNode minRoot = getMin(root.right);
            root.val = minRoot.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root){
        while(root.left!= null)
            root = root.left;
        return root;
    }

}
