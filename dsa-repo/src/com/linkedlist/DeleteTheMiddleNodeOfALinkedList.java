package com.linkedlist;
/*
2095. Delete the Middle Node of a Linked List

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,
where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Example 1:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.

Logic
------
get mid element and store its previous node in another Node.
then put prev Node's next to slow Node's next.
 */
public class DeleteTheMiddleNodeOfALinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        new DeleteTheMiddleNodeOfALinkedList().deleteMiddle(head);
        new PrintLinkedList().print(head);
    }
    public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next==null)
            return null;
        ListNode slow = head, prev = null, fast = head;

        while(fast!=null && fast.next != null){
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }

        if(slow!=null)
            prev.next = slow.next;

        return head;

    }
}
