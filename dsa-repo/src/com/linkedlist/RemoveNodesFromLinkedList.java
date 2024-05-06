package com.linkedlist;

import java.util.Stack;

/*
2487. Remove Nodes From Linked List

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

 */
public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next =  new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        new PrintLinkedList().print(new RemoveNodesFromLinkedList().removeNodesV1(head));
        System.out.println();
        new PrintLinkedList().print(new RemoveNodesFromLinkedList().removeNodesV2(head));
    }

    public ListNode removeNodesV1(ListNode head) {
        Stack<ListNode> st = new Stack<>();

        ListNode cur = head;

        while(cur != null){
            if(st.isEmpty()){
                st.push(cur);
            } else{
                while(!st.isEmpty() && st.peek().val<cur.val){
                    st.pop();
                }
                st.push(cur);
            }
            cur = cur.next;
        }

        ListNode tempHead = null;

        while(!st.isEmpty()){
            st.peek().next = tempHead;
            tempHead = st.pop();
        }

        return tempHead;
    }

    public ListNode removeNodesV2(ListNode head) {

        // reverse the list
        head = reverse(head);

        // have a dummy node for linking expected nodes
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        // have one max variable to track max value
        int max = -1;

        // iterate over all nodes
        while(head != null){
            if(head.val >= max){
                max = head.val;
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;
        }
        dummy.next = null;

        head = reverse(temp.next);
        return head;
    }

    ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head, prev = null;
        while(cur!= null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
