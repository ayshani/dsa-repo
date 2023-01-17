package com.tree;
/*
1483. Kth Ancestor of a Tree Node

You are given a tree with n nodes numbered from 0 to n - 1 in the form of a parent array parent where
parent[i] is the parent of ith node. The root of the tree is node 0. Find the kth ancestor of a given node.

The kth ancestor of a tree node is the kth node in the path from that node to the root node.

Implement the TreeAncestor class:

TreeAncestor(int n, int[] parent) Initializes the object with the number of nodes in the tree and the parent array.
int getKthAncestor(int node, int k) return the kth ancestor of the given node node.
If there is no such ancestor, return -1.


Example 1:

Input
["TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"]
[[7, [-1, 0, 0, 1, 1, 2, 2]], [3, 1], [5, 2], [6, 3]]
            0
        1        2
    3      4   5     6


Output
[null, 1, 0, -1]

Explanation
TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
treeAncestor.getKthAncestor(3, 1); // returns 1 which is the parent of 3
treeAncestor.getKthAncestor(5, 2); // returns 0 which is the grandparent of 5
treeAncestor.getKthAncestor(6, 3); // returns -1 because there is no such ancestor

TC : o(nlogn)
SC : o(nlogn)

 */
public class KthAncestorOfATreeNode {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }
}


class TreeAncestor {

    int jump[][];
    int maxPow;

    public TreeAncestor(int n, int[] parent) {
        // this denotes to depth of the tree i.e. max height of the tree
        this.maxPow = (int) (Math.log(n)/Math.log(2)) + 1;

        // a 2D array with max depth and n nodes.
        // so, for single column, all values of different height is stored.
        jump = new int[this.maxPow][n];
        jump[0] = parent;
        for(int p=1;p<maxPow;p++){
            for(int j=0;j<n;j++){
                int pre = jump[p-1][j];
                jump[p][j] = pre == -1 ? -1 : jump[p-1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int maxP = this.maxPow;
        while(k>0 && node>-1){
            if(k>= 1<< maxP){
                node = jump[maxP][node];
                k -= 1 << maxP;
            } else{
                maxP-=1;
            }
        }
        return node;
    }
}