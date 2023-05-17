package com.array;

import java.util.Arrays;

/*
Move All Negative Numbers To Beginning And Positive To End

https://www.codingninjas.com/codestudio/problem-of-the-day/easy?leftPanelTab=0
 */
public class MoveAllNegativeNumbersToBeginningAndPositiveToEnd {

    public static void main(String[] args) {
        int[] a = new int[]{1,-4,-2,5,3};
        new MoveAllNegativeNumbersToBeginningAndPositiveToEnd().separateNegativeAndPositive(a);
        Arrays.stream(a).forEach(System.out::println);
    }
    public void separateNegativeAndPositive(int a[]) {
        int mid =0, low =0, high = a.length-1;
        while(mid<=high){
            if(a[mid]<0){
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                low++;
                mid++;
            } else{
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
    }
}
