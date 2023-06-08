package com.binarysearch;
/*
Allocate minimum number of pages

https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
https://www.geeksforgeeks.org/allocate-minimum-number-pages/

You have N books, each with Ai number of pages. M students need to be allocated contiguous books, with each student
getting at least one book. Out of all the permutations, the goal is to find the permutation where the student with
the most pages allocated to him gets the minimum number of pages, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order
(see the explanation for better understanding).

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

TC : o(nlogn)
SC: o(1)
 */
public class AllocateMinimumNumberOfPages {

    public static void main(String[] args) {
        int[] a = new int[]{12,34,67,90};
        System.out.println(new AllocateMinimumNumberOfPages().findPages(a,4,2));
    }
    public int findPages(int[]a,int n,int m)
    {
        //Your code here
        int sum = 0, max = 0;
        if(n<m)
            return -1;
        for(int i = 0; i <n; i++){
            sum= sum+a[i];
            max = Math.max(max,a[i]);
        }
        if(m == 1){
            return sum;
        }
        int low = max, high = sum, res = -1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(isFeasible(a,n,m,mid)){
                res = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return res;
    }

    /*
    the idea is to find out whether we are bale to allocate in <= number of friends
    if we able to allocate in less than what is required(mid below), that means there is a chance we can allocate
    with more in later iteration. But incase if we got more than the required one, that means with this
    mid value, we are allocating less. Hence, we need to increase the size of mid. So, returning false
     */
    boolean isFeasible(int[] a, int n, int m, int mid){
        int req = 1, sum = 0;
        for(int i = 0;i<n;i++){
            if(sum + a[i]>mid){
                req++;
                sum = a[i];
            } else {
                sum = sum + a[i];
            }
        }
        return (req<=m);
    }
}
