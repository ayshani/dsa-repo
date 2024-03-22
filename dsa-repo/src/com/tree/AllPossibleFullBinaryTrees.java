package com.tree;

import java.util.*;

/*
894. All Possible Full Binary Trees

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the
answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Example 1:
Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
        [0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

Algorithm
Create a hash map memo where memo[i] contains the list of root nodes of all possible full binary trees with i nodes.
If n is even, we return an empty list as we cannot form any full binary tree with even number of nodes.
If n == 1, we simply return a list with single node.
If we already have solved this subproblem, i.e., memo contains the key n, we return memo[n].
We have odd n. We declare a list of TreeNode called res to store the list of root nodes of all possible full binary
    trees with n nodes.
Iterate from i = 1 to n - 1 incrementing i by 2 after each iteration:
Create a list of TreeNode called left to store the root nodes for all possible full binary trees using i nodes.
    We perform left = allPossibleFBT(i).
Create a list of TreeNode called right to store the root nodes for all possible full binary trees using n - 1 - i
    nodes. We perform right = allPossibleFBT(n - i - 1).
Iterate over both the lists left and right using two loops. For each element count in left and r in right,
    we create a new root node and set root.left = l and root.right = r. We add root into our answer variable res.
Set memo[n] equal to res.
Return res.


Complexity Analysis
Note, the time and space complexity of this problem is difficult to derive exactly. In an interview, do your best
to calculate an upper bound while explaining your thought process.

Time complexity: O(2^{n/2})

The maximum number of nodes that can be in the left subtree of a full binary tree with n nodes is n - 2, since one
node is the root of the tree and one node must be in the right subtree. Therefore, the total number of possible full
binary trees with n nodes can be calculated by considering all possible combinations of the number of nodes in the
left and right subtrees, such that the sum of the number of nodes in the left and right subtrees is equal to n - 1.
We can express the total number of possible full binary trees with n nodes as a recurrence relation
    T(n) = T(1) * T(n - 2) + T(3) * T(n - 4) + ... + T(n - 2) * T(1), where the summation goes over all odd numbers
    from 1 to n - 2. Solving this recurrence relation using dynamic programming shows that T(n) is equal to the
    n^{th} Catalan number, which is bounded by 2^{n/2}.
Our implementation generates all of these trees taking O(2^{n/2} time.
Space complexity: O(n.2^{n/2})
The algorithm uses memoization to store the results of subproblems. Specifically, it uses a hash map called
memo to store the results of subproblems that have already been solved.
For every subproblem with n nodes, the algorithm may need to store up to 2^{n/2} TreeNode objects in the memo hash map.
 This is because there can be up to 2n/22^{n/2}2
n/2 possible full binary trees with n nodes, and the algorithm needs to store all of them in order to return the
result for the subproblem with n number of nodes. There are maximum of n/2 subproblems (with nodes 1, 3, .. n - 1)
and hence the space complexity of the algorithm is O(n. 2^{n/2}).
 */
public class AllPossibleFullBinaryTrees {

    public static void main(String[] args) {
        System.out.println(new AllPossibleFullBinaryTrees()
                .allPossibleFBT(7));
    }
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0){
            return new ArrayList<TreeNode>();
        }

        if(n==1)
            return Arrays.asList(new TreeNode());
        if(memo.containsKey(n))
            return memo.get(n);
        List<TreeNode> res = new ArrayList<TreeNode>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);

            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(0,l,r);
                    res.add(root);
                }
            }
        }
        memo.put(n,res);
        return res;
    }
}
