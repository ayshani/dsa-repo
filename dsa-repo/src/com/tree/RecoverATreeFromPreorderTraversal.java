package com.tree;

import com.linkedlist.PrintLinkedList;

import java.util.Stack;

/*
1028. Recover a Tree From Preorder Traversal

We run a preorder depth-first search (DFS) on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

If a node has only one child, that child is guaranteed to be the left child.

Given the output traversal of this traversal, recover the tree and return its root.



Example 1:
Input: traversal = "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]

 */
public class RecoverATreeFromPreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new RecoverATreeFromPreorderTraversal().recoverFromPreorder( "1-2--3--4-5--6--7");
        new TreeTraversal().printTreeLevelOrder(root);
    }
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        while (index < traversal.length()) {
            // Count the number of dashes
            int depth = 0;
            while (
                    index < traversal.length() && traversal.charAt(index) == '-'
            ) {
                depth++;
                index++;
            }

            // Extract the node value
            int value = 0;
            while (
                    index < traversal.length() &&
                            Character.isDigit(traversal.charAt(index))
            ) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            // Create the current node
            TreeNode node = new TreeNode(value);

            // Adjust the stack to the correct depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach the node to the parent
            if (!stack.empty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            // Push the current node onto the stack
            stack.push(node);
        }

        // The root is the first node in the stack
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
