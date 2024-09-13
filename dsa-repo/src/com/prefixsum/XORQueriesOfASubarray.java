package com.prefixsum;

import java.util.Arrays;

/*
1310. XOR Queries of a Subarray

You are given an array arr of positive integers. You are also given the array queries where
queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR
arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.



Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8

TC : o(n)
SC: o(n)
 */
public class XORQueriesOfASubarray {

    public static void main(String[] args) {
        int[] res = new XORQueriesOfASubarray().xorQueries(
                new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}}
        );
        Arrays.stream(res).forEach(System.out::println);
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for(int i=1; i<n;i++){
            prefixXor[i] = prefixXor[i-1] ^ arr[i];
        }

        int[] res = new int[m];
        for(int i=0;i<m;i++){
            int left = queries[i][0], right = queries[i][1];
            if(left==0){
                res[i] = prefixXor[right];
            } else{
                res[i] = prefixXor[right] ^ prefixXor[left-1];
            }
        }
        return res;
    }
}
