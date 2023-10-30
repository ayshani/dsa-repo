package com.bit.manipulation;

import java.util.Arrays;
import java.util.Comparator;

/*
1356. Sort Integers by The Number of 1 Bits

You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their
binary representation and in case of two or more integers have the same number of 1's you have to sort them in
ascending order.

Return the array after sorting it.



Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

TC : o(nlogn)
SC: o(logn) // o(n)
 */
public class SortIntegersByTheNumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortIntegersByTheNumberOf1Bits().sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
    }
    public int[] sortByBits(int[] arr) {

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, new CustomComparator());
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    private int findWeight(int num){
        int weight =0;
        while(num >0){
            weight++;
            num &= (num-1);
        }
        return weight;
    }

    @Override
    public int compare(Integer a, Integer b){
        if(findWeight(a)== findWeight(b))
            return a-b;
        return findWeight(a) - findWeight(b);
    }
}
