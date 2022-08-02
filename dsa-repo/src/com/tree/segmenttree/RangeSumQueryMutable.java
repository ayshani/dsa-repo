package com.tree.segmenttree;
/*
307. Range Sum Query - Mutable

Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

Logic
-----
Go through segment tree concept
https://ide.geeksforgeeks.org/w2FEOGK6h5
https://ide.geeksforgeeks.org/yxnjwQBLsu
https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/


TC : o(logn)
SC : o(4*n)
 */
public class RangeSumQueryMutable {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray obj = new NumArray(nums);

        System.out.println(obj.sumRange(0,2));
        obj.update(1,2);
        System.out.println(obj.sumRange(0,2));
    }


}

class NumArray {
    private int[] tree;
    int n;
    private int[] nums;
    public NumArray(int[] nums) {
        if(nums.length>0){
            n = nums.length;
            this.nums=nums;
            tree = new int[4*n];
            construct(0,n-1,0,this.nums);
        }
        /*for(int i=0;i<4*n;i++){
            System.out.print(tree[i]+" ");
        }*/
    }

    public void update(int index, int val) {
        int diff = val - this.nums[index];
        this.nums[index]= val;
        updateRec(0,n-1,index,0,diff);
    }

    public int sumRange(int left, int right) {
        return getSumRec(left,right,0,n-1,0);
    }

    int construct(int ss, int se, int si, int nums[]){
        if(ss==se){
            tree[si] = nums[ss];
            return nums[ss];
        }
        int mid = (ss + se)/2;
        tree[si] = construct(ss,mid,(2*si + 1),nums) + construct(mid+1,se,(2*si + 2),nums);
        return tree[si];
    }

    int getSumRec(int qs,int qe,int ss,int se,int si){
        if(se < qs || ss> qe)
            return 0;
        if(qs<=ss && qe>=se)

            return tree[si];

        int mid =(ss+se)/2;

        return (getSumRec(qs,qe,ss,mid,(2*si + 1)) + getSumRec(qs,qe,mid+1,se,(2*si + 2)));
    }

    void updateRec(int ss,int se, int i, int si, int diff){
        if(i<ss || i>se)
            return;

        tree[si] = tree[si] + diff;

        if(se>ss){
            int mid = (ss+se)/2;

            updateRec(ss,mid,i,(2*si+1),diff);
            updateRec(mid+1,se,i,(2*si+2),diff);
        }
    }
}
