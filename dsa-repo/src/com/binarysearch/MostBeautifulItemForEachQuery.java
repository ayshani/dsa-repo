package com.binarysearch;

import java.util.Arrays;

/*
2070. Most Beautiful Item for Each Query

You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.

You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.

Return an array answer of the same length as queries where answer[j] is the answer to the jth query.



Example 1:

Input: items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
Output: [2,4,5,5,6,6]
Explanation:
- For queries[0]=1, [1,2] is the only item which has price <= 1. Hence, the answer for this query is 2.
- For queries[1]=2, the items which can be considered are [1,2] and [2,4].
  The maximum beauty among them is 4.
- For queries[2]=3 and queries[3]=4, the items which can be considered are [1,2], [3,2], [2,4], and [3,5].
  The maximum beauty among them is 5.
- For queries[4]=5 and queries[5]=6, all items can be considered.
  Hence, the answer for them is the maximum beauty of all items, i.e., 6.

TC : o(nlogn)
SC: o(n)
 */
public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        System.out.println(new MostBeautifulItemForEachQuery().maximumBeauty(
                new int[][]{
                        {1,2},{3,2},{2,4},{5,6},{3,5}
                }, new int[]{1,2,3,4,5,6}
        ));
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int m = queries.length, n = items.length;
        int[] ans = new int[m];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = items[0][1];
        for(int i=0;i<n;i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        for(int i=0;i<m;i++){
            ans[i] = binarySearch(items, queries[i]);
        }
        return ans;
    }

    private int binarySearch(int[][] items, int targetPrice){
        int l =0, r=items.length-1, max = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(items[mid][0]> targetPrice){
                r = mid-1;
            } else{
                max = Math.max(max, items[mid][1]);
                l = mid +1;
            }
        }
        return max;
    }
}
