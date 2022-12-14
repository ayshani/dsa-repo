package com.linkedlist;
/*
328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes
with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
1 - 2 - 3 - 4 - 5
o/p: 1 - 3 - 5 - 2 - 4

 */
public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next =  new ListNode(2);
        node.next.next =  new ListNode(3);
        node.next.next.next =  new ListNode(4);
        node.next.next.next.next =  new ListNode(5);

        ListNode lst = new OddEvenLinkedList().oddEvenList(node);
        new PrintLinkedList().print(lst);
    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode odd =  head, even = head.next, evenHead = even;

        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
