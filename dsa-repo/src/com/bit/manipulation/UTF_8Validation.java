package com.bit.manipulation;
/*
393. UTF-8 Validation

Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).

A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For a 1-byte character, the first bit is a 0, followed by its Unicode code.
For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

     Number of Bytes   |        UTF-8 Octet Sequence
                       |              (binary)
   --------------------+-----------------------------------------
            1          |   0xxxxxxx
            2          |   110xxxxx 10xxxxxx
            3          |   1110xxxx 10xxxxxx 10xxxxxx
            4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
x denotes a bit in the binary form of a byte that may be either 0 or 1.

Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
This means each integer represents only 1 byte of data.



Example 1:

Input: data = [197,130,1]
Output: true
Explanation: data represents the octet sequence: 11000101 10000010 00000001.
It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
Example 2:

Input: data = [235,140,4]
Output: false
Explanation: data represented the octet sequence: 11101011 10001100 00000100.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.

 /*
     * Thought-way:
     * As long as every byte in the array is of right type, it is a valid UTF-8 encoding.
     *
     * Method:
     * Start from index 0, determine each byte's type and check its validity.
     *
     * There are five kinds of valid byte type: 0**, 10**, 110**,1110** and 11110**
     * Give them type numbers, 0, 1, 2, 3, 4 which are the index of the first 0 from left.
     * So, the index of the first 0 determines the byte type.
     *
     * if a byte belongs to one of them:
        1 : if it is type 0, continue
        2 : if it is type 2 or 3 or 4, check whether the following 1, 2, and 3 byte(s) are of type 1 or not
                if not, return false;
     * else if a byte is type 1 or not of valid type, return false
     *
     * Analysis :
     * The faster you can determine the type, the quicker you can get.
     * Time O(n), space O(1)
     * real performance: 7ms


// Hard code "masks" array to find the index of the first appearance of 0 in the lower 8 bits of each integer.
 */
public class UTF_8Validation {
    int[] mask = new int[]{128,64, 32,16,8};

    public static void main(String[] args) {
        int[] data = new int[]{235,140,4};
        System.out.println(new UTF_8Validation().validUtf8(data));
    }
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for(int i=0;i<n;i++){
            int type = getType(data[i]);
            if(type==0)
                continue;
            else if(type>1 && type+i<=n){
                while(type-->1){
                    if(getType(data[++i])!=1)
                        return false;
                }
            } else
                return false;
        }

        return true;
    }

    private int getType(int num){
        for(int i=0;i<5;i++){
            if((mask[i]&num)==0)
                return i;
        }

        return -1;
    }

}
