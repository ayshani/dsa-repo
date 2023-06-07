package com.binarysearch;
/*
1231. Divide Chocolate

You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array
sweetness.

You want to share the chocolate with your k friends so you start cutting the chocolate bar into k + 1 pieces
using k cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.



Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], k = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

TC: o(nlogn)
SC: o(1)
 */
public class DivideChocolate {

    public static void main(String[] args) {
        int[] sweetness = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(new DivideChocolate().maximizeSweetness(sweetness,5));
    }
    public int maximizeSweetness(int[] sweetness, int k) {
        int n = sweetness.length;
        int totalFriend = k+1; // include myself
        int low = Integer.MAX_VALUE, high =0, ans =0;

        for(int num : sweetness){
            low = Math.min(low, num);
            high += num;
        }

        while(low<=high){
            int mid = low +(high -low)/2;
            if(canDivideChocolate(sweetness,mid,totalFriend)){
                // if we are able to properly divide, that means either
                // we have divided in more chunks than required or equal.
                // in this case, we can take the ans and try to go for bigger
                // chunk size.
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean canDivideChocolate(int[] sweetness, int mid, int totalFriend){
        int currentSweetness =0, chunk  =0;
        for(int num : sweetness){
            currentSweetness += num;
            // we are assigning to one chunk till it becomes >= mid
            // as we need minimum of mid sweetness and
            // as if we consider one sweetnees, we can't take partial.
            // w ehave to take whole. in that case, it can become more than mid
            if(currentSweetness >= mid){
                chunk++;
                currentSweetness=0;
            }
        }
        return chunk>=totalFriend;
    }
}
