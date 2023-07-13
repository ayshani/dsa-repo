package com.bit.manipulation;
/*
461. Hamming Distance

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.



Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1,4));
    }
    public int hammingDistance(int x, int y) {
        int count =0;
        while(x!=0 || y!=0){
            int lsb = ((x&1)^(y&1));
            if(lsb==1)
                count++;
            x=x>>1;
            y=y>>1;
        }
        return count;
    }
}
