package com.sort;

import java.util.Arrays;

/*
2418. Sort the People

You are given an array of strings names, and an array heights that consists of distinct positive integers.
Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.



Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.

TC : o(nlogn)
SC: o(n)

 */
public class SortThePeople {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortThePeople().sortPeople(
                new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}
        )));
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for(int i=0;i<n;i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] sortedNames = new String[n];
        for(int i=0;i<n;i++){
            sortedNames[i] = names[indices[i]];
        }
        return sortedNames;
    }
}
