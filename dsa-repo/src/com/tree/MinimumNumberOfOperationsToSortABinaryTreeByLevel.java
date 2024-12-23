package com.tree;

import java.util.*;

/*
2471. Minimum Number of Operations to Sort a Binary Tree by Level

You are given the root of a binary tree with unique values.

In one operation, you can choose any two nodes at the same level and swap their values.

Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.

The level of a node is the number of edges along the path between it and the root node.



Example 1:Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.

TC : o(nlogn)
SC: o(n)
 */
public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new MinimumNumberOfOperationsToSortABinaryTreeByLevel().minimumOperations(root));
    }
    public int minimumOperations(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int totalSwapes =0;

        while(!q.isEmpty()){
            int levelSize = q.size();
            int[] levelValues = new int[levelSize];
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                levelValues[i] = node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            totalSwapes += getMinSwap(levelValues);
        }
        return totalSwapes;
    }

    private int getMinSwap(int[] original){
        int swap =0;
        int[] target = original.clone();
        Arrays.sort(target);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<original.length;i++){
            map.put(original[i],i);
        }

        for(int i=0;i<original.length;i++){
            if(original[i] != target[i]){
                swap++;

                int curPos = map.get(target[i]);
                map.put(original[i],curPos);
                original[curPos] = original[i];
            }
        }
        return swap;
    }
}
