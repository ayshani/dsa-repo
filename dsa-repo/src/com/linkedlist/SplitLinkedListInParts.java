package com.linkedlist;
/*
725. Split Linked List in Parts

Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
This may lead to some parts being null.
The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have
a size greater than or equal to parts occurring later.

Return an array of the k parts.

Example 1:
Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].

TC : o(n)
SC : o(n)
 */
public class SplitLinkedListInParts {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next =  new ListNode(2);
        node.next.next =  new ListNode(3);
        node.next.next.next =  new ListNode(4);
        node.next.next.next.next =  new ListNode(5);
        node.next.next.next.next.next =  new ListNode(6);
        node.next.next.next.next.next.next =  new ListNode(7);
        node.next.next.next.next.next.next.next =  new ListNode(8);
        node.next.next.next.next.next.next.next.next =  new ListNode(9);
        node.next.next.next.next.next.next.next.next.next =  new ListNode(10);

        ListNode[] res = new SplitLinkedListInParts().splitListToParts(node,3);
        new PrintLinkedList().printList(res);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int n =0;
        while(cur!=null){
            cur= cur.next;
            n++;
        }

        int width = n/k, rem = n%k;

        ListNode[] ans = new ListNode[k];
        cur = root;

        for(int i=0;i<k;i++){
            ListNode head = cur;
            for(int j=0; j< width + (i<rem ? 1 : 0)-1;j++){
                if(cur!=null)
                    cur = cur.next;
            }

            if(cur!=null){
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }

            ans[i] = head;
        }

        return ans;
    }
}
