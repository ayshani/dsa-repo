package com.heap.min;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
373. Find K Pairs with Smallest Sums

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

TC : o(klogk)
SC: o(k)
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,7,11}, num2 = new int[]{2,4,6};
        System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(num1,num2,3));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if(m==0 || n==0 || k<1)
            return result;

        PriorityQueue<Data> pq = new PriorityQueue<>((a, b)-> a.val-b.val);
        pq.offer(new Data(0,0,nums1[0]+nums2[0]));

        while(!pq.isEmpty() && k>0){
            Data d = pq.poll();
            result.add(List.of(nums1[d.i],nums2[d.j]));
            k--;
            //add the next column item
            if(d.j<n-1){
                pq.offer(new Data(d.i,d.j+1,nums1[d.i]+ nums2[d.j+1]));
            }
            // always store the next row (smallest)
            if(d.j==0 && d.i<m-1){
                pq.offer(new Data(d.i+1, 0, nums1[d.i+1]+ nums2[0]));
            }
        }
        return result;
    }
}

class Data{
    int i,j,val;
    public Data(int i, int j, int val){
        this.i =i;
        this.j = j;
        this.val =val;
    }
}
