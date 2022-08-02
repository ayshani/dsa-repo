package com.linkedlist;
/*
203. Remove Linked List Elements

Given the head of a linked list and an integer val,
remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next =  new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(6);

        new RemoveLinkedListElements().removeElements(head,6);
        new PrintLinkedList().print(head);
    }
    public ListNode removeElements(ListNode head, int val) {


        while(head!=null && head.val==val)
            head=head.next;
        if(head==null)
            return null;
        ListNode A = head;
        while(A.next!=null){
            if(A.next.val==val){
                A.next= A.next.next;
            } else
                A=A.next;
        }

        return head;
    }
}
