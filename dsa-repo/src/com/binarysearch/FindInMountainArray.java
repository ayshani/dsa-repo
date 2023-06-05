package com.binarysearch;
/*
1095. Find in Mountain Array

(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions
that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

TC: o(logn)
SC: o(1)
 */
public class FindInMountainArray {

    public static void main(String[] args) {
        MountainArray ar = new MountainArray(new int[]{1,2,3,4,5,3,1});
        System.out.println(new FindInMountainArray().findInMountainArray(3,ar));
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = getPeak(mountainArr);
        int index = binarySearch(mountainArr,0,peak, target);
        if(index!=-1)
            return index;
        else
            return binarySearch(mountainArr,peak+1,mountainArr.length()-1, target);
    }

    private int getPeak(MountainArray mountainArr){
        int l =0, r =mountainArr.length()-1;
        while(l<r){
            int mid = l+(r-l)/2;

            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                r = mid;
            } else
                l = mid+1;
        }

        return l;
    }

    private int binarySearch(MountainArray mountainArr, int l, int r, int target){
        boolean asc = mountainArr.get(l)<mountainArr.get(r);

        while(l<=r){
            int mid = l+(r-l)/2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(asc){
                if(target<mountainArr.get(mid)){
                    r = mid-1;
                } else
                    l = mid+1;
            } else {
                if(target>mountainArr.get(mid)){
                    r = mid-1;
                } else
                    l = mid+1;
            }
        }
        return -1;
    }
}

class MountainArray{
    int[] arr;

    public MountainArray(int[] ar){
        arr = ar;
    }

    public int get(int index){
        return arr[index];
    }

    public int length(){
        return arr.length;
    }
}
