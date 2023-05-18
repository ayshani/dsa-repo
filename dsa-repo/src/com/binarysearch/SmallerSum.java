package com.binarysearch;

import java.util.Arrays;

/*
Smaller sum

https://practice.geeksforgeeks.org/contest/weekly-interview-series-71/problems/#

You are given an integer array arr of n size. For each index i, you have to find the sum of all integers present
in the array with the value less than arr[i].

Example 1:
Input:
n = 3
arr = {1, 2, 3}
Output:
0 1 3
Explanation:
For 1, there are no elements lesser than itself.
For 2, only 1 is lesser than 2.
And for 3, 1 and 2 are lesser than 3, so the sum is 3.

TC : o(nlogn)
SC : o(n)
 */
public class SmallerSum {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 1, 8, 9, 3, 2, 1};
        long[] resv1 = new SmallerSum().smallerSumV1(8,arr);
        Arrays.stream(resv1).forEach(e -> System.out.print(e+" "));
        System.out.println();
        long[] resv2 = new SmallerSum().smallerSumV2(8,arr);
        Arrays.stream(resv2).forEach(e -> System.out.print(e+" "));

    }
    public long[] smallerSumV1(int n,int arr[])
    {
        int[] temp = arr.clone();

        Arrays.sort(temp);

        long[] pref = new long[n];
        pref[0]=temp[0];
        for(int i=1;i<n;i++){
            pref[i]= pref[i-1]+temp[i];
            // System.out.print(pref[i]+" ");
        }
        // System.out.println();
        long[] ans = new long[n];
        for(int i=0;i<n;i++){
            // get index in temp through binary search
            int index = Arrays.binarySearch(temp,arr[i]);
            // get the lower bound of the index i.e. smallest index for which
            // arr[i] is same as temp[i]
            while(index>0){
                if(temp[index-1] == arr[i])
                    index--;
                else
                    break;
            }

            if(index==0){
                ans[i]=0;
            } else{
                index--;
                //System.out.println(arr[i] +" " +temp[index] +" "+pref[index]);
                ans[i]= pref[index];
            }
        }

        return ans;
    }

    public long[] smallerSumV2(int n,int arr[])
    {
        int[] temp = arr.clone();
        Arrays.sort(temp);

        long[] prefixSum = new long[n];
        prefixSum[0] = temp[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + temp[i];
        }
        long[] res = new long[n];

        for(int i=0;i<n;i++){
            int lowerBoundIndex = binarySearch(temp, arr[i]);
            if(lowerBoundIndex==0)
                res[i] = 0;
            else
                res[i] = prefixSum[lowerBoundIndex-1];
        }
        return res;
    }

    private int binarySearch(int[] arr, int target){
        int low =0, high = arr.length-1;

        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]<target){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        return high;
    }
}
