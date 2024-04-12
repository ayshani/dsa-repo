package com.twopointer;
/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Logic
-----
we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would
be dependent on height of bar in current direction (from left to right). As soon as we find the bar at other end
(right) is smaller, we start iterating in opposite direction (from right to left). We must maintain left_max and
right_max during the iteration, but now we can do it in one iteration using 2 pointers, switching between the two.

Complexity analysis

Time complexity: O(n). Single iteration of O(n).
Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] h = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(h));
    }
    public int trap(int[] height) {
        int left =0, right = height.length-1;
        int ans = 0;
        int leftMax =0, rightMax =0;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax)
                    leftMax= height[left];
                else
                    ans+= leftMax- height[left];
                left++;
            } else{
                if(height[right]>=rightMax)
                    rightMax= height[right];
                else
                    ans+= rightMax- height[right];
                right--;
            }
        }

        return ans;
    }
}
