package com.graph.unionfind;
/*
1361. Validate Binary Tree Nodes

You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i],
return true if and only if all the given nodes form exactly one valid binary tree.

If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

Note that the nodes have no values and that we only use the node numbers in this problem.

Example 1:
Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
Output: true

Explanation
----------
This solution uses Union Find (a.k.a Disjoint Set Union) which counts connected components and allows only
the single child-root assignment.

Time complexity: O(N log * N).
Space complexity: O(N).

 */
public class ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        int n = 4, left[] = new int[]{1,-1,3,-1}, right[] = new int[]{2,-1,-1,-1};
        System.out.println(new ValidateBinaryTreeNodes().validateBinaryTreeNodes(n,left,right));
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;i++){
            if(leftChild[i] >=0 && !uf.unionWithoutRanking(i,leftChild[i]))
                return false;
            if(rightChild[i] >=0 && !uf.unionWithoutRanking(i,rightChild[i]))
                return false;
        }

        return uf.count==1;
    }
}
