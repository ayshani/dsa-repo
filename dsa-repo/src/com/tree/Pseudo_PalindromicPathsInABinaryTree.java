package com.tree;
/*
1457. Pseudo-Palindromic Paths in a Binary Tree

Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be
pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Example 1:
Input: root = [2,3,1,3,1,null,1]
                    2
                 3     1
               3   1      1
Output: 2
Explanation: The figure above represents the given binary tree. There are three paths going from the root node
to leaf nodes: the path A [2,3,3], the  path B [2,1,1], and the path [2,3,1].
Among these paths only A path and B path are pseudo-palindromic paths since the A path [2,3,3]
can be rearranged in [3,2,3] (palindrome) and the B path [2,1,1] can be rearranged in [1,2,1] (palindrome).

Logic
-------
Two subproblems
The problem consists of two subproblems:
- Traverse the tree to build all root-to-leaf paths.
- For each root-to-leaf path, check if it's a pseudo-palindromic path or not.

Root-to-leaf traversal is so-called DFS preorder traversal.
To implement it, one has to follow the straightforward strategy Root->Left->Right.
It's quite evident that the path is pseudo-palindromic, if it has at most one digit with an odd frequency.

Complexity Analysis

Time complexity: O(N) since one has to visit each node, check if at most one digit has an odd frequency.

Space complexity: up to O(H) to keep the recursion stack, where H is a tree height.
 */
public class Pseudo_PalindromicPathsInABinaryTree {

    int count =0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(new Pseudo_PalindromicPathsInABinaryTree().pseudoPalindromicPaths(root));

    }
    public int pseudoPalindromicPaths (TreeNode root) {
        preorder(root,0);
        return count;
    }

    private void preorder(TreeNode root, int path){
        if(root==null)
            return;
        // compute occurences of each digit
        // in the corresponding register
        System.out.println("path before: "+path);
        path = path^(1<< root.val);
        System.out.println("path after: "+path);
        // if it's a leaf check if the path is pseudo-palindromic
        if(root.left==null && root.right==null){
            // check if at most one digit has an odd frequency
            if((path&(path-1))==0)
                count++;
        }

        preorder(root.left,path);
        preorder(root.right,path);
    }
}
