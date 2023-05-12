package com.array;

import java.util.ArrayList;
import java.util.List;

/*
Sum Of Infinite Array
https://www.codingninjas.com/codestudio/problems/sum-of-infinite-array_873335?leftPanelTab=0

 */
public class SumOfInfiniteArray {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,6,9};
        List<List<Long>> queries = new ArrayList<>();
        queries.add(new ArrayList<>());
        queries.get(0).add(10L);
        queries.get(0).add(13L);

        System.out.println(sumInRanges(arr,4, queries,1));
    }
    static int  mod = (int) 1e9+7;
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

        // Write your code here!
        List<Integer> result = new ArrayList<Integer>();

        long[] prefixSum = new long[n+1];
        for(int i=1;i<=n;i++){
            prefixSum[i] = (prefixSum[i-1]+ arr[i-1])%mod;
        }

        for(List<Long> range : queries){
            long left = range.get(0), right = range.get(1);
            long rightSum = addUtil(prefixSum, n, right);
            long leftSum = addUtil(prefixSum,n,left-1);
            int res = (int)(rightSum - leftSum + mod)%mod;
            result.add(res);
        }

        return result;
    }

    private static long addUtil(long[] prefixSum, long length, long index){
        long numberOfIterativeCount = (index/length)%mod;
        long res = (numberOfIterativeCount * prefixSum[(int)length])%mod;
        res = (res+ prefixSum[(int)(index%length)])%mod;
        return res;
    }
}
