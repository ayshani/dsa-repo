package com.linkedlist;

import java.util.List;

/*
2181. Merge Nodes in Between Zeros

You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and
end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum
of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

Example 1:
Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

TC : o(n)
SC: o(1)
 */
public class MergeNodesInBetweenZeros {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        new PrintLinkedList().print(new MergeNodesInBetweenZeros().mergeNodes(head));
    }
    public ListNode mergeNodes(ListNode head) {
        ListNode cur = head.next, nextSum = cur;

        while(nextSum!=null){
            int sum =0;
            while(nextSum.val !=0){
                sum+=nextSum.val ;
                nextSum = nextSum.next;
            }

            cur.val = sum;
            nextSum = nextSum.next;
            cur.next = nextSum;
            cur = cur.next;
        }
        return head.next;
    }
}
