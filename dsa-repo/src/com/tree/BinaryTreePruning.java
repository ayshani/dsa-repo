package com.tree;
/*
814. Binary Tree Pruning

Given the root of a binary tree, return the same tree where every subtree
(of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

Example 1:

Input: root = [1,null,0,0,1]
            1                1
               0     ->>        0
             0    1                1
Output: [1,null,0,null,1]
Explanation:
Only the 1,0,1 nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
Intuition

Prune children of the tree recursively. The only decisions at each node are whether to
prune the left child or the right child.

Algorithm

We'll use a function containsOne(node) that tells us whether the subtree at this node contains a 1,
and prunes all subtrees that do not contain 1.

If for example, node.left subtree does not contain a one, then we should prune it via node.left = null.

Also, the parent needs to be checked. If for example the tree is a single node 0, the answer is an empty tree.


Complexity Analysis

Time Complexity: O(N), where NN is the number of nodes in the tree. We process each node once.

Space Complexity: O(N), the recursion call stack can be as large as the height HH of the tree.
In the worst case scenario, H=NH=N, when the tree is skewed.
 */
public class BinaryTreePruning {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        new TreeTraversal().printTreeLevelOrder(new BinaryTreePruning().pruneTree(root));
    }
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root){
        if(root==null)
            return false;

        boolean leftContainsOne = containsOne(root.left);
        boolean rightContainsOne = containsOne(root.right);

        if(!leftContainsOne)
            root.left = null;
        if(!rightContainsOne)
            root.right = null;

        return root.val==1 || leftContainsOne || rightContainsOne;
    }
}
