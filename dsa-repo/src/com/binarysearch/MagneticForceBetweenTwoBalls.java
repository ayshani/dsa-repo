package com.binarysearch;

import java.util.Arrays;

/*
1552. Magnetic Force Between Two Balls

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in
his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs
to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs
[3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.

TC : o(nlogn) + o(nlog((n*k)/m))
SC: o(logn)
 */
public class MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(
                new int[]{1,2,3,4,7}, 3
        ));
    }
    public int maxDistance(int[] position, int m) {
        int ans =0;
        int n = position.length;
        Arrays.sort(position);

        int low =1, high = (int) Math.ceil(position[n-1]/ (m-1.0));
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canPlaceBalls(position, m, mid)){
                ans = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return ans;
    }

    private boolean canPlaceBalls(int[] position,int m,int mid){
        int prevPosition = position[0];
        int total =1;
        for(int i=1; i<position.length && total<m ; i++){
            int curPosition = position[i];
            if(curPosition - prevPosition >= mid){
                total++;
                prevPosition = curPosition;
            }
        }
        return total == m;
    }

}
