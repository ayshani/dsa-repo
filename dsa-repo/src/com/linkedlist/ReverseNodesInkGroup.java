package com.linkedlist;
/*
25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

TC : o(n)
SC : o(n)
 */
public class ReverseNodesInkGroup {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next =  new ListNode(2);
        node.next.next =  new ListNode(3);
        node.next.next.next =  new ListNode(4);
        node.next.next.next.next =  new ListNode(5);
        node.next.next.next.next.next =  new ListNode(6);
        node.next.next.next.next.next.next =  new ListNode(7);
        new PrintLinkedList().print(new ReverseNodesInkGroup().reverseKGroup(node,3));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;

        int count =0;
        while(cur!=null && count!=k){
            cur =cur.next;
            count++;
        }

        if(count==k){
            cur = reverseKGroup(cur,k);

            while(count-->0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;

            }
            head = cur;
        }

        return head;
    }
}
