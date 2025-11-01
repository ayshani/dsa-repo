package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
3217. Delete Nodes From Linked List Present in Array

You are given an array of integers nums and the head of a linked list. Return the head of the modified linked
list after removing all nodes from the linked list that have a value that exists in nums.

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:
Remove the nodes with values 1, 2, and 3.

TC : o(n)
SC: o(n)
 */
public class DeleteNodesFromLinkedListPresentInArray {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next =  new ListNode(1);
        head.next.next.next = new ListNode(9);

        head = new DeleteNodesFromLinkedListPresentInArray().modifiedList(new int[]{1,9}, head);
        new PrintLinkedList().print(head);
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Create a HashSet for efficient lookup of values in nums
        Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums) {
            valuesToRemove.add(num);
        }

        // Handle the case where the head node needs to be removed
        while (head != null && valuesToRemove.contains(head.val)) {
            head = head.next;
        }
        // If the list is empty after removing head nodes, return null
        if (head == null) {
            return null;
        }
        // Iterate through the list, removing nodes with values in the set
        ListNode current = head;
        while (current.next != null) {
            if (valuesToRemove.contains(current.next.val)) {
                // Skip the next node by updating the pointer
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}
