package com.bit.manipulation;
/*
137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once.
Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Explanantion
----------------
The logical thinking behind this approach is to count the number of 1s at each bit position for all the numbers.
Since each number appears three times except for the single number, the sum of 1s at each bit position should be
divisible by 3 for a balanced line. Any number of 1s that is not divisible by 3 indicates an unbalanced line,
which means the single number contributes to that particular bit position.

By masking the positions of the unbalanced lines with 1s in ans, we effectively isolate the bits that are part of
the single number. Finally, the resulting value in ans represents the binary representation of the single number.

Using the provided example: [1, 1, 1, 2, 2, 2, 5]

At the LSB (i = 0), the sum of the number of 1s is 3 (balanced line).
At the second bit (i = 1), the sum of the number of 1s is 4 (unbalanced line, not divisible by 3).
At the third bit (i = 2), the sum of the number of 1s is 2 (unbalanced line, not divisible by 3).
At the fourth bit
(i = 3), the sum of the number of 1s is 1 (balanced line).

Thus, the resulting binary representation is '0101', which corresponds to the decimal value 5, and that is the
single number we are searching for.

This approach effectively identifies the unbalanced lines and constructs the single number by setting the
corresponding bit positions in ans.

TC : o(n*32)
SC: o(1)
 */
public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,2};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        //Initialize the variable ans to 0. This variable will store the resulting single number.
        int ans =0;
        //Iterate from i = 0 to i = 31. This loop considers each bit position from
        // the least significant bit (LSB) to the most significant bit (MSB) of a 32-bit integer.
        for(int i=0;i<32;i++){
            //Inside the loop, initialize a variable sum to 0. This variable will keep track of the
            // number of 1s at the current bit position (i) for all the numbers in the input array.
            int sum =0;
            //Iterate through each number num in the input array:
            for(int num : nums){
                /*
                Right-shift num by i positions: num >> i. This operation moves the bit at position i to the least
                significant bit position.
                Perform a bitwise AND with 1: (num >> i) & 1. This extracts the value of the bit at position i
                from num. If it is 1, the result will be 1; otherwise, it will be 0.
                Add the result of (num >> i) & 1 to sum. This counts the number of 1s at bit position i for
                all the numbers in the array.
                 */
                sum += num>>i&1;
            }
            /*
            Take the modulo of sum by 3: sum %= 3. This step is performed to handle the numbers that appear
            three times. If sum is divisible by 3, it means the bit at position i has a balanced number of 1s.
            Otherwise, it is an unbalanced line.
             */
            sum %=3;

            /*
            Left-shift the value of sum by i positions: sum << i. This step creates a bitmask pos where only the
            bit at position i is set to the value of sum. This bitmask identifies the position of the unbalanced line.

            Use the bitwise OR operation with ans and pos: ans |= pos. This sets the corresponding bit in ans
            to 1 if the bit at position i is part of an unbalanced line.
             */
            ans |= sum<<i;
        }
        return ans;
    }
}
