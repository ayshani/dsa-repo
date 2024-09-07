package com.tree;

import com.linkedlist.ListNode;

/*
1367. Linked List in Binary Tree

Given a binary tree root and a linked list with head as the first node.

Return True if all the elements in the linked list starting from the head correspond to some downward path
connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.
Example 1:

Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
                  1
             4        4
               2    2
             1    6    8
                     1   3
Output: true
Explanation: Nodes in blue form a subpath in the binary Tree.

Time O(N * min(L,H))
Space O(H)
where N = tree size, H = tree height, L = list length.

 */
public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        System.out.println(new LinkedListInBinaryTree().isSubPath(head,root));
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null)
            return true;

        if(root==null)
            return false;

        return dfs(head,root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root){
        if(head==null)
            return true;

        if(root==null)
            return false;

        return root.val==head.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
