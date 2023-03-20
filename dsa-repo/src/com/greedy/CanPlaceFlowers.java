package com.greedy;
/*
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer
n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.



Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

TC : o(n)
SC: o(1)
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] f = new int[]{1,0,0,0,1};
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(f,2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;

        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                boolean leftEmpty = (i==0) || (flowerbed[i-1]==0);
                boolean rightEmpty = (i==flowerbed.length-1) || (flowerbed[i+1]==0);

                if(leftEmpty && rightEmpty){
                    flowerbed[i] = 1;
                    count++;
                    if(count>=n)
                        return true;
                }
            }
        }

        return count>=n;
    }
}
