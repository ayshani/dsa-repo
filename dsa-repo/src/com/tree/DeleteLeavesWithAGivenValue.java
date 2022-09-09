package com.tree;
/*
1325. Delete Leaves With a Given Value

Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
and has the value target, it should also be deleted (you need to continue doing that until you cannot).

Example 1:
Input: root = [1,2,3,2,null,2,4], target = 2
        1                1                1
      2    3     ->>   2    3    ->>         3
    2     2  4                4                4
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).

Logic
--------
Recursively call removeLeafNodes on the left and right.
If root.left == root.right == null and root.val == target,
the root node is now a leaf with value = target, we return null.
Otherwise return root node itself.


Complexity
Time O(N)
Space O(height) for recursion.
 */
public class DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        new TreeTraversal().printTreeLevelOrder(new DeleteLeavesWithAGivenValue().removeLeafNodes(root,2));
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.left!=null)
            root.left = removeLeafNodes(root.left,target);
        if(root.right!=null)
            root.right = removeLeafNodes(root.right,target);

        return root.left == root.right && root.val == target ? null : root;
    }

}
