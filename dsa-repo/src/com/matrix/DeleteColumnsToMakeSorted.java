package com.matrix;
/*
944. Delete Columns to Make Sorted

You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.
For example, strs = ["abc", "bce", "cae"] can be arranged as:

abc
bce
cae
You want to delete the columns that are not sorted lexicographically.
In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted
while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.

Example 1:

Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.

TC : o(m*n)
SC : o(1)
 */
public class DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        String[] words = new String[]{"cba","daf","ghi"};
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(words));
    }
    public int minDeletionSize(String[] strs) {
        int n =  strs.length, wordSize = strs[0].length();
        int count =0;
        for(int i=0;i<wordSize;i++){
            for(int j=0;j<n-1;j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
