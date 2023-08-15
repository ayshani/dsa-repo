package com.twopointer;

import com.linkedlist.ListNode;
import com.linkedlist.PrintLinkedList;

/*
86. Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes
greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

TC: o(n)
SC: o(n)
 */
public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        new PrintLinkedList().print(new PartitionList().partition(head,3));
    }

    public ListNode partition(ListNode head, int x) {
        /*
        Logic
         -----------

         Logic is to have two pointers - before and after.
         before points to the list whose node evalue are less than x and
         after points to the list whose node evalue are greater than x



        */

        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);


        ListNode before = before_head, after = after_head;

        while(head!= null){
            if(head.val<x){
                before.next = head;
                before = before.next;
            } else{
                after.next = head;
                after= after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
