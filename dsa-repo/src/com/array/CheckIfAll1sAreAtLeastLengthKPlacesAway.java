package com.array;
/*
1437. Check If All 1's Are at Least Length K Places Away

Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

Example 1:
Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.

TC : o(n)
Sc: o(1)
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public static void main(String[] args) {
        System.out.println(new CheckIfAll1sAreAtLeastLengthKPlacesAway().kLengthApart(
                new int[]{1,0,0,0,1,0,0,1}, 2
        ));
    }
    public boolean kLengthApart(int[] nums, int k) {
        int prevPos = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]== 1){
                if(prevPos == -1){
                    prevPos = i;
                } else{
                    int distance = i-prevPos-1;
                    if(distance < k){
                        return false;
                    }
                    prevPos = i;
                }
            }
        }
        return true;
    }
}
