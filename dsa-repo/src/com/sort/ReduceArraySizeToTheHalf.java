package com.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
1338. Reduce Array Size to The Half

You are given an integer array arr. You can choose a set of integers and
remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.



Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5
(i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which
has a size greater than half of the size of the old array.

Logic
------
Have the count occurrence of evey element in hashmap
create the sorted list from the values of the map.
Iterate over the list in descending order.
    start having cumulative sum.
    check if the sum is greate than half of the size of original array.
        If yes break and return
        if not, then add the cumulative sum and add increment the count
once done, return count
TC : o(nlogn)
SC : o(n)
 */
public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,3,5,5,5,2,2,7};

        System.out.println(new ReduceArraySizeToTheHalf().minSetSize(arr));
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        List<Integer> ls = new ArrayList(hm.values());

        Collections.sort(ls);
        int sum =0,count=0;
        for(int i=ls.size()-1;i>=0;i--){
            if(sum>=n/2)
                break;
            else{
                sum+=ls.get(i);
                count++;
            }
        }

        return count;
    }
}
