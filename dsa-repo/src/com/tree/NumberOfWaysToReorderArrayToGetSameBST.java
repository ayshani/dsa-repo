package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
1569. Number of Ways to Reorder Array to Get Same BST
Given an array nums that represents a permutation of integers from 1 to n. We are going to construct a binary
search tree (BST) by inserting the elements of nums in order into an initially empty BST. Find the number of
different ways to reorder nums so that the constructed BST is identical to that formed from the original array nums.

For example, given nums = [2,1,3], we will have 2 as the root, 1 as a left child, and 3 as a right child.
The array [2,3,1] also yields the same BST but [3,2,1] yields a different BST.
Return the number of ways to reorder nums such that the BST formed is identical to the original BST formed from nums.

Since the answer may be very large, return it modulo 109 + 7.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 5
Explanation: The following 5 arrays will yield the same BST:
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]

Explanation :
---------------
This is actually a mathematical problem that can be solved by combination calculation, what'd you do is basically
arranging left and right sub-trees in correct order but in all possible combinations.
For example for array [3,6,4,1] ::
[3,6,4,1] left sub tree is [1], right tree is [6,4],
we just need to keep 6 appear in front of 4 to make permutation a valid one,
so combinations can be [6,4,1], [6,1,4], [1,6,4]
Obviously, if left sub tree length is 1 and total length is 3, combination is 3C1 which is 3

Expand to a more complicated case [3,6,4,1,7] ::
left sub tree is [1], right tree is [6,4,7],
permutations for right tree itself is [6,4,7], [6,7,4] which means it's 2C1 (combination of [4] and [7])
for every permuration of right tree you can also combine it with left tree [1] so total # is 4C1*2C1=8

Pseudo code :
def dfs(nums):
	if len(nums) <= 2:
		return 1
	left = [x in nums which < nums[0]]
	right = [x in nums which > nums[0]]
	return combination(len(lefft+right), len(left)) * dfs(left) * dfs(right)

Here comes the tricky part for Java, doing mathematical stuff in Java is really a PAIN in the ass since it doesn't
have comb() function in python and it doesn't support long long, I didn't know why the hint is dynamic programming,
now I get it, I can use Yang Hui/Pascal's triangle to speed up calculation.

TC:
generating Pascal triangle will take o(n^2)
generating the combination will be as per master theorem -
    t(n) = 2*T(n/2) +n
    here a=2, b =2
    hence, logb a =1
    hence it applies to second case of Master theorem :
        If f(n) = Θ(nlogb a), then T(n) = Θ(nlogb a * log n).
    so , => o(nlogn)

hence worst tiem complexity : o(n^2)

SC : o(n^2)
 */
public class NumberOfWaysToReorderArrayToGetSameBST {

    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,4,1,7};
        System.out.println(new NumberOfWaysToReorderArrayToGetSameBST().numOfWays(nums));
    }
    public int numOfWays(int[] nums) {
        int len = nums.length;
        List<Integer> arr = new ArrayList<>();
        for(int num : nums){
            arr.add(num);
        }
        long[][] pascalTriangle = getPascalTriangle(len+1);

        return (int)getCombination(arr, pascalTriangle) -1;
    }

    long[][] getPascalTriangle(int n){
        // Yang Hui (Pascle) triangle
        // 4C2 = triangle[4][2] = 6
        long[][] triangle = new long[n][n];
        for(int i=0;i<n;i++){
            triangle[i][0] = triangle[i][i] =1;
        }

        for(int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                triangle[i][j] = (triangle[i-1][j-1] + triangle[i-1][j])%MOD;
            }
        }
        return triangle;
    }

    long getCombination(List<Integer> nums, long[][] pascalTriangle){
        if(nums.size()<=2){
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for(int num : nums){
            if(num < root){
                left.add(num);
            }else if(num > root){
                right.add(num);
            }
        }

        // mod every number to avoid overflow
        return (pascalTriangle[left.size()+right.size()][left.size()] *
                (getCombination(left,pascalTriangle)%MOD)%MOD ) *
                getCombination(right,pascalTriangle)%MOD;

    }
}
