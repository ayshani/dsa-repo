package com.tree;
/*
2096. Step-By-Step Directions From a Binary Tree Node to Another

You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n.
You are also given an integer startValue representing the value of the start node s,
and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t.
Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'.
Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

Example 1:
            5
         1     2
       3     6   4
Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.

TC : o(m*n)
SC : o(1)
 */
public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(new StepByStepDirectionsFromABinaryTreeNodeToAnother()
                .getDirections(root,3,6));
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startToRoot = new StringBuilder();
        StringBuilder endToRoot = new StringBuilder();

        dfs(root,startValue,startToRoot);
        dfs(root,destValue,endToRoot);

        int i= startToRoot.length(), j = endToRoot.length();
        int count =0;

        // startToRoot.charAt(i-1)==endToRoot.charAt(j-1) this comes when destination and source are in the same side
        // of the tree. hence, that section we can omit as we create the patch from source to root /
        // destination to root. hence we count the common section.
        while(i>0 && j>0 && startToRoot.charAt(i-1)==endToRoot.charAt(j-1)){
            count++;
            i--;
            j--;
        }

        // once we get the common length of the two path
        // we remove that section from startToRoot path and rest is converted to U i.e. upper.
        String sPath = "U".repeat(startToRoot.length()-count);

        // similarly for destinationToRoot also, we omit the common length and make
        // the reverse of the current orientation.
        String ePath = endToRoot.reverse().substring(count, endToRoot.length());
        return sPath+ePath;
    }

    private boolean dfs(TreeNode root, int dist, StringBuilder path){
        if(root==null)
            return false;

        if(root.val == dist)
            return true;
        if(dfs(root.left,dist,path))
            path.append("L");
        else if(dfs(root.right,dist,path))
            path.append("R");

        return path.length()>0;
    }
}
