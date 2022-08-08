package com.tree;
/*
988. Smallest String Starting From Leaf

You are given the root of a binary tree where each node has a value in the range [0, 25]
representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.
Example 1:

Input: root = [0,1,2,3,4,3,4]

            a
         b     c
       d   e  d  e
Output: "dba" (smallest)

Logic
-------
Let's create every possible string - then we can compare them and choose the best one.

Algorithm

In our depth first search, we will maintain sb (or A in Python),
the contents of a path from the root to this node.

When we reach a leaf, we will reverse this path to create a candidate answer.
If it is better than our current answer, we'll update our answer.

TC : o(nlogn)
We use O(N) to traverse the array and maintain A [Python] or sb.
Then, our reversal and comparison with the previous answer is O(L),
where L is the size of the string we have when at the leaf.
For example, for a perfectly balanced tree, L=logN and the time complexity would be O(NlogN).

SC : o(n)
 */
public class SmallestStringStartingFromLeaf {

    String ans = "~";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(new SmallestStringStartingFromLeaf().smallestFromLeaf(root));
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());

        return ans;
    }

    private void dfs(TreeNode root, StringBuilder sb){
        if(root==null)
            return;

        sb.append((char)('a'+ root.val));

        if(root.left ==null && root.right == null)
        {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();

            if(s.compareTo(ans)<0)
                ans = s;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);

        sb.deleteCharAt(sb.length()-1);
    }
}
