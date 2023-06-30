package com.linkedlist;
/*
83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

TC : o(n)
SC: o(1)
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(5);
        head.next.next = new ListNode(7);
        head.next.next.next =  new ListNode(7);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);
        new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        new PrintLinkedList().print(head);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        if(head== null)
            return head;
        while(cur!=null){
            if(cur.next!=null && cur.val==cur.next.val){
                ListNode temp = cur.next;
                while(temp!= null && temp.val==cur.val){
                    temp = temp.next;
                }
                cur.next = temp;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
