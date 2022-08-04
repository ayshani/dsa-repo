package com.binarysearch;
/*
1891. Cutting Ribbons

You are given an integer array ribbons, where ribbons[i] represents the length of the i-th ribbon,
and an integer k. You may cut any of the ribbons into any number of segments of positive integer lengths,
or perform no cuts at all.

For example, if you have a ribbon of length 4, you can:
Keep the ribbon of length 4,
Cut it into one ribbon of length 3 and one ribbon of length 1,
Cut it into two ribbons of length 2,
Cut it into one ribbon of length 2 and two ribbons of length 1, or
Cut it into four ribbons of length 1.
Your goal is to obtain k ribbons of all the same positive integer length. You are allowed to
throw away any excess ribbon as a result of cutting.

Return the maximum possible positive integer length that you can obtain k ribbons of, or 0 if
you cannot obtain k ribbons of the same length.

Example 1:

Input: ribbons = [9,7,5], k = 3

Output: 5

Explanation:

Cut the first ribbon to two ribbons, one of length 5 and one of length 4.
Cut the second ribbon to two ribbons, one of length 5 and one of length 2.
Keep the third ribbon as it is.
Now you have 3 ribbons of length 5.


Logic
-------
we get the Max ribbon length at first cause this will be maximum we can cut one ribbon to.
So, our binary search rang will start from [0,maxRibbon].

once we got this, we get the mid element and check if we are able to cut all the ribbon length
by that midLength and the number of the cuts is equivalent to given k cuts,
we go for next higher space range ( mid,high)
else
    go for (0,mid-1).

TC : o(n)
SC : o(1)
 */
public class CuttingRibbons {

    public static void main(String[] args) {
        int[] ribbons = new int[]{7,5,9};
        int k =3;
        System.out.println(new CuttingRibbons().maxLength(ribbons,k));
    }
    public int maxLength(int[] ribbons, int k){

        int maxRibbon =0;
        for(int ribbon : ribbons){
            maxRibbon = Math.max(ribbon,maxRibbon);
        }

        int low =0, high = maxRibbon;
        while(low < high){
            int mid = low+(high-low)/2 +1;

            if(canCutRibbons(ribbons,mid, k)){
                low = mid;
            } else
                high = mid -1;
        }

        return low;
    }

    private boolean canCutRibbons(int[] ribbons, int mid, int k){
        int cutCount =0;

        for(int ribbon : ribbons){
            cutCount+= ribbon/mid;
        }

        return cutCount>=k;
    }
}
