package com.linkedlist;
/*
 * 430. Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list, which contains nodes that have a next pointer,
 * a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes. These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure as shown in the example below.
 *
 * Given the head of the first level of the list,
 * flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * Let curr be a node with a child list.
 * The nodes in the child list should appear after curr and before curr.next in the flattened list.
 *
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 *
 * Example
 *
 * 1 -- 2
 * |
 * 3
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation: The multilevel linked list in the input is shown.
 * After flattening the multilevel linked list it becomes:
 *
 * 1 -- 3 -- 2
 * Logic
 * -----------
 * 1. Start form the head , move one step each time to the next node
 * 2. When meet with a node with child, say node cur, follow its child
 *    chain to the end and connect the tail node with cur.next, by doing this we merged the child chain back to the main thread
 * 3. Return to cur and proceed until find next node with child.
 * 4. Repeat until reach null
 *
 * TC : O(n)
 * SC : o(1)
 */
public class FlattenAMultilevelDoublyLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.child =  new Node(3);
        head.child.prev = head;

        FlattenAMultilevelDoublyLinkedList obj = new FlattenAMultilevelDoublyLinkedList();
        obj.flatten(head);

        obj.print(head);
    }

    private void print(Node head) {
        // TODO Auto-generated method stub
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public Node flatten(Node head) {
        if(head==null)
            return head;
        Node cur = head;
        while(cur!=null){
            if(cur.child==null)
            {
                cur=cur.next;
                continue;
            }

            Node temp = cur.child;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next =cur.next;
            if(cur.next!=null)
                cur.next.prev = temp;
            cur.next = cur.child;
            cur.child.prev =cur;
            cur.child = null;
        }

        return head;
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int val){
        this.val = val;
    }
};

