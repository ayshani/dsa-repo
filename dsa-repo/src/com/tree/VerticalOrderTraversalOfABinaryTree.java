package com.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
987. Vertical Order Traversal of a Binary Tree

Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1)
and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column
index starting from the leftmost column and ending on the rightmost column.
There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Example 1:
Input: root = [3,9,20,null,null,15,7]
                3
            9      20
                15          7
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
 */
public class VerticalOrderTraversalOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new VerticalOrderTraversalOfABinaryTree().verticalTraversal(root));
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        PriorityQueue<Point> pq = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.x != p2.x)
                        return p1.x - p2.x;
                    else if (p1.y != p2.y)
                        return p2.y - p1.y;
                    else
                        return p1.val - p2.val;
                }
        );

        dfs(root,0,0, pq);
        int prev = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(p.x>prev){
                List<Integer> ls = new ArrayList<>();
                ls.add(p.val);
                result.add(ls);
            } else{
                List<Integer> ls = result.get(result.size()-1);
                ls.add(p.val);
            }
            prev = p.x;
        }
        return result;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> pq){
        if(root==null)
            return;
        pq.offer(new Point(x,y,root.val));
        dfs(root.left, x-1,y-1,pq);
        dfs(root.right, x+1,y-1,pq);
    }
}

class Point{
    int x,y, val;
    Point(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
