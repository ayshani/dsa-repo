package com.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
2251. Number of Flowers in Full Bloom

You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be
in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where
people[i] is the time that the ith person will arrive to see the flowers.

Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the
ith person arrives.

Example 1:
Input: flowers = [[1,6],[3,7],[9,12],[4,13]], poeple = [2,3,7,11]
Output: [1,2,2,2]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.

TC : o((mlogm + mlogm + nlogm)
SC : o(m)
 */
public class NumberOfFlowersInFullBloom {

    public static void main(String[] args) {
        int[][] flowers = new int[][]{
                {1,6},{3,7},{9,12},{4,13}
        };
        int[] people = new int[]{2,3,7,11};
        System.out.println(Arrays.toString(new NumberOfFlowersInFullBloom().fullBloomFlowers(flowers,people)));
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> start = new ArrayList<>(), end = new ArrayList<>();
        for(int[] flower : flowers){
            start.add(flower[0]);
            end.add(flower[1] + 1);
        }

        Collections.sort(start);
        Collections.sort(end);

        int[] res = new int[people.length];

        for(int index =0; index <people.length;  index++){
            int person = people[index];
            // right most insertion point for person
            int i = binarySearch(start, person);
            // right most insertion point sinces previous
            // flowers stop blooming.
            int j = binarySearch(end, person);
            res[index] = i-j;
        }
        return res;
    }

    private int binarySearch(List<Integer> arr, int target){
        int left =0, right = arr.size();
        while(left<right){
            int mid = left+(right-left)/2;
            if(target<arr.get(mid)){
                right = mid;
            } else{
                left = mid +1;
            }
        }
        return left;
    }
}
