package com.tree;

import com.linkedlist.ListNode;

/*
109. Convert Sorted List to Binary Search Tree

Given the head of a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

Example :
Input: head = [-10,-3,0,5,9]
            0
         -3    9
       -10   5
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.


Logic
-------
compute mid element and create the root .
then recursively call from head to mid and mid+1 to tail.

TC : o(nlogn)
SC : o(n)
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next =  new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(head);

        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail){
        if(head==tail)
            return null;

        ListNode slow = head, fast = head;

        while(fast!=tail && fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);

        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next,tail);

        return thead;
    }
}
