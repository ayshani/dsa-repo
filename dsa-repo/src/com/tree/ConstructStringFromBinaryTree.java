package com.tree;
/*
606. Construct String from Binary Tree

Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree
with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between
the string and the original binary tree.

Example 1:
Input: root = [1,2,3,4]
        1
      2    3
    4
Output: "1(2(4))(3)"
Explanation: Originally, it needs to be "1(2(4)())(3()())", but you need to omit all the
unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"

Logic
------
Case 1: Both the left child and the right child exist for the current node. In this case, we need to put the braces ()
around both the left child's preorder traversal output and the right child's preorder traversal output.

Case 2: None of the left or the right child exist for the current node. In this case, as shown in the figure below,
considering empty braces for the null left and right children is redundant.
Hence, we need not put braces for any of them.

Case 3: Only the left child exists for the current node. As the figure below shows, putting empty braces for the right
child in this case is unnecessary while considering the preorder traversal. This is because the right child will always
come after the left child in the preorder traversal. Thus, omitting the empty braces for the right child also leads to
same mapping between the string and the binary tree.

Case 4: Only the right child exists for the current node. In this case, we need to consider the empty braces for
the left child. This is because, during the preorder traversal, the left child needs to be considered first.
Thus, to indicate that the child following the current node is a right child we need to put a pair of empty braces
for the left child.

Just by taking care of the cases, mentioned above, we can obtain the required output string.

Complexity Analysis

Time complexity : O(n). The preorder traversal is done over the n nodes of the given Binary Tree.

Space complexity : O(n). The depth of the recursion tree can go upto n in case of a skewed tree.
 */
public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(new ConstructStringFromBinaryTree().tree2str(root));
    }

    public String tree2str(TreeNode root) {
        if(root==null)
            return "";
        if(root.left==null && root.right==null)
            return root.val+"";
        if(root.right==null)
            return root.val+"("+tree2str(root.left)+")";
        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
    }
}
