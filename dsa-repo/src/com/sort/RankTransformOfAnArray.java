package com.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 1331. Rank Transform of an Array
 *
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *
 * Example 1:
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 *
 * TC : o(n)
 * SC : o(n)
 */
public class RankTransformOfAnArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = new int[] {40,10,20,30};
        RankTransformOfAnArray obj = new RankTransformOfAnArray();
        int[] res = obj.arrayRankTransform(arr);
        for(int e : res) {
            System.out.print(e+ " ");
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr,arr.length);
        Arrays.sort(A);
        Map<Integer,Integer> map = new HashMap<>();

        for(int x : A){
            map.putIfAbsent(x,map.size()+1);
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

}

