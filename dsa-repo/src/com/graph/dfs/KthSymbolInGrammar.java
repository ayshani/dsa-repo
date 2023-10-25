package com.graph.dfs;
/*
779. K-th Symbol in Grammar

We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.



Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:

Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01

Algo :
Create a method depthFirstSearch which takes n number of rows in the current tree, k target node position in the
last row, and rootVal current tree's root's value as parameters:

If n is 1, then we will have a single node in our tree and this node is our target node. So, we return its
value rootVal.

Find the number of nodes in the last row of the current tree, totalNodes, 2^{(n - 1)}.

If the current target node k lies in the left half of the last row of the current subtree (i.e. k <= totalNodes / 2),
we will move to the left sub-tree.
If the current node's value rootVal is 0 then the next node's value will be 0, otherwise, the next node's value will
be 1.
Return depthFirstSearch(n - 1, k, nextRootVal).

Otherwise, if the current target node k lies in the right half of the last row of the current subtree
(i.e. k > totalNodes / 2), we will move to the right sub-tree.
If the current node's value rootVal is 0 then the next node's value will be 1, otherwise, the next node's value
will be 0.
Additionally, the target's position will change to (k - (totalNodes / 2)).
Return depthFirstSearch(n - 1, newPosition, nextRootVal).

We return the result returned by calling depthFirstSearch(n, k, 0) with the number of rows as n, target node
position k, and root node's value 0.

TC : o(n)
SC: o(n)
 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {
        System.out.println(new KthSymbolInGrammar().kthGrammar(30,21));
    }
    public int kthGrammar(int n, int k) {
        return dfs(n, k, 0);
    }

    private int dfs(int n, int k, int rootVal){
        if(n==1)
            return rootVal;

        int totalNodes = (int) Math.pow(2,n-1);
        // Target node will be present in the right half sub-tree of the current root node.
        if(k>(totalNodes/2))
        {
            int nextRootVal = (rootVal==0)? 1 :0;
            return dfs(n-1, k -(totalNodes/2), nextRootVal);
        }
// Otherwise, the target node is in the left sub-tree of the current root node.
        else{
            int nextRootVal = (rootVal==0)? 0 :1;
            return dfs(n-1, k, nextRootVal);
        }

    }
}
