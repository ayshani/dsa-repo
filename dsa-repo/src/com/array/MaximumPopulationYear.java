package com.array;
/*
1854. Maximum Population Year

You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years
of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in
year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted
in the year that they die.

Return the earliest year with the maximum population.

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

Constraints:

1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050

TC : o(n)
SC: o(2050)
 */
public class MaximumPopulationYear {

    public static void main(String[] args) {
        int[][] logs = new int[][]{
                {1993,1999},{2000,2010}
        };
        System.out.println(new MaximumPopulationYear().maximumPopulation(logs));
    }
    public int maximumPopulation(int[][] logs) {
        int maxYear = 0;
        int[] year = new int[2051];
        for(int[] log : logs){
            year[log[0]]++;
            year[log[1]]--;
        }
        for(int i=1950;i<year.length;i++){
            year[i] +=year[i-1];
            maxYear = year[maxYear]<year[i] ? i : maxYear;
        }
        return maxYear;
    }
}
