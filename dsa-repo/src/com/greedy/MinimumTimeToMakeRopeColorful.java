package com.greedy;
/*
1578. Minimum Time to Make Rope Colorful

Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of
the ith balloon.

Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks
Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer
array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.

Return the minimum time Bob needs to make the rope colorful.



Example 1:
Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3

TC : o(n)
SC: o(1)
 */
public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        System.out.println(new MinimumTimeToMakeRopeColorful().minCost("abaac", new int[]{1,2,3,4,5}));
    }
    public int minCost(String colors, int[] neededTime) {
        int res =0, sumCost=0,maxCost=0;
        for(int i=0;i<colors.length();i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                res+=sumCost-maxCost;
                sumCost=0;
                maxCost=0;
            }
            sumCost+=neededTime[i];
            maxCost= Math.max(maxCost,neededTime[i]);
            System.out.println(i +" "+ sumCost +" "+ maxCost +" "+res);
        }
        res+=sumCost-maxCost;
        return res;
    }
}
