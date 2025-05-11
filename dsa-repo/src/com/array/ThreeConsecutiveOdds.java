package com.array;
/*
1550. Three Consecutive Odds

Given an integer array arr, return true if there are three consecutive odd numbers in the array.
Otherwise, return false.


Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.

TC : o(n)
SC: o(1)
 */
public class ThreeConsecutiveOdds {

    public static void main(String[] args) {
        System.out.println(new ThreeConsecutiveOdds().threeConsecutiveOdds(
                new int[]{2,6,4,1}
        ));
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length, i=0;

        while(i<n){
            if(arr[i]%2!=0){
                int count =1, j=i+1;
                while(j<n){
                    if(arr[j]%2!=0){
                        j++;
                        count++;
                    } else{
                        break;
                    }
                }
                if(count==3){
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
