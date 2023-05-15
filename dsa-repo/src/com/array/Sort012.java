package com.array;

import java.util.Arrays;

/*
Sort 0 1 2

https://www.codingninjas.com/codestudio/problems/sort-0-1-2_631055?leftPanelTab=0
inp:
2
6
0 1 2 2 1 0
7
0 1 2 1 2 1 2

Sample Output 1 :
0 0 1 1 2 2
0 1 1 1 2 2 2

TC : o(n)
SC: o(1)
 */
public class Sort012 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,0,1};
        sort012(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort012(int[] arr)
    {
        //Write your code here
        int mid =0, low =0, high = arr.length-1;

        while(mid<=high){
            if(arr[mid]==0){
                int temp =arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            } else if(arr[mid]==1)
            {
                mid++;
            } else{
                int temp =arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
    }
}
