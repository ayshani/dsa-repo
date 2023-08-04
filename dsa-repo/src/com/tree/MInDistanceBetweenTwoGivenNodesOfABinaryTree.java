package com.tree;
/*
Min distance between two given nodes of a Binary Tree

https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

Given a binary tree and two node values your task is to find the minimum distance between them.
The given two nodes are guaranteed to be in the binary tree and nodes are numbered from 1 to N.
Please Note that a and b are not always leaf node.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 2
Explanation: The tree formed is:
       1
     /   \
    2     3
We need the distance between 2 and 3.
Being at node 2, we need to take two
steps ahead in order to reach node 3.
The path followed will be:
2 -> 1 -> 3. Hence, the result is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findDist() which takes the
root node of the Tree and the two node values a and b as input parameters and returns the minimum distance between
the nodes represented by the two given node values.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 105

TC : o(n)
SC: o(logn)
 */
public class MInDistanceBetweenTwoGivenNodesOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        System.out.println(new MInDistanceBetweenTwoGivenNodesOfABinaryTree().findDist(root,4,8));
    }
    int d1,d2,dist;
    /*
    Idea  is :
    get LCA and also the level of a node and b node
    incase, we have both he distance,i,e, both are in different subtree, then get the distance which
    got calculated during finding LCA.
    i.e. distance_from_root(a) + distance_from_root(b) - 2 * current of LCA
    if, either of distance remains -1,i,e, one of the node is the parent of another,
    in that case, get the distance from LCA to that another node whose distance is not yet visited.
     */
    int findDist(TreeNode root, int a, int b) {
        // Your code here
        d1=-1;
        d2=-1;
        dist=0;
        TreeNode nodeLCA = lca(root, a,b,0);
        if(d1!=-1 && d2!=-1){
            return dist;
        }

        if(d1!=-1){
            dist = length(nodeLCA, b,0);
        }

        if(d2!=-1){
            dist = length(nodeLCA, a,0);
        }
        return dist;
    }

    private int length(TreeNode root, int x, int level){
        if(root==null)
            return -1;
        if(root.val==x)
            return level;
        int left = length(root, x, level+1);
        return left!=-1? left : length(root.right, x , level+1);
    }

    private TreeNode lca(TreeNode root, int x, int y, int level){
        if(root==null)
            return root;
        if(root.val==x){
            d1= level;
            return root;
        }
        if(root.val==y){
            d2= level;
            return root;
        }
        TreeNode left = lca(root.left, x,y,level+1);
        TreeNode right = lca(root.right, x,y,level+1);

        if(left!= null && right != null){
            dist = d1 + d2 - 2 *level;
            return root;
        }

        return left!= null ? left : right;
    }
}
