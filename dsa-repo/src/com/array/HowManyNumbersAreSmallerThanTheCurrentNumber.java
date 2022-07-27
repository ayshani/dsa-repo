package com.array;

/*
 * 1365. How Many Numbers Are Smaller Than the Current Number
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 * Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).


 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = new int[] {8,1,2,2,3};
        HowManyNumbersAreSmallerThanTheCurrentNumber obj = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        int[] res = obj.smallerNumbersThanCurrent(nums);

        for(int e : res)
            System.out.print(e+" ");
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[101];
        int n = nums.length;
        for(int i=0;i<n;i++)
            bucket[nums[i]]++;

        for(int i=1;i<101;i++){
            bucket[i] +=bucket[i-1];
        }

        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int position = nums[i];
            res[i] = position ==0 ? 0 : bucket[position-1];
        }

        return res;
    }

}
