package com.tree;

import java.util.HashMap;
import java.util.Map;

/*
437. Path Sum III

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the
values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards
(i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
                10
             5      -3
          3     2      11
        3  -2     1
Output: 3
Explanation: The paths that sum to 8 are (3,5),(5,2,1),9-3,11)

TC : o(n)
SC : o(n)
 */
public class PathSumIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left =  new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        System.out.println(new PathSumIII().pathSumIII(root,8));
    }
    public int pathSumIII(TreeNode root, int target){
        Map<Long,Long> map = new HashMap<>();
        map.put(0L,1L);
        return (int)dfs(root,target,0,map);
    }

    private long dfs(TreeNode root, int target,long curSum,Map<Long,Long> map){
        if(root==null)
            return 0;

        curSum+= root.val;
        long count = map.getOrDefault(curSum-target,0L);
        map.put(curSum, map.getOrDefault(curSum,0L)+1);
        count+= dfs(root.left,target,curSum,map) + dfs(root.right,target,curSum,map);

        map.put(curSum, map.get(curSum)-1);

        return count;
    }
}
