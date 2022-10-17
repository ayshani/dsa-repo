package com.binarysearch;
/*
275. H-Index II

Given an array of integers citations where citations[i] is the number of citations a researcher received for
their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at
least h citations each, and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.

You must write an algorithm that runs in logarithmic time.



Example 1:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6
            citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations
each, their h-index is 3.

Logic
------
Just binary search, each time check citations[mid]
case 1: citations[mid] == len-mid,
        then it means there are citations[mid] papers that have at least citations[mid] citations.
case 2: citations[mid] > len-mid,
        then it means there are citations[mid] papers that have moret than citations[mid] citations, so we should continue searching in the left half
case 3: citations[mid] < len-mid,
        we should continue searching in the right side

After iteration, it is guaranteed that right+1 is the one we need to find (i.e. len-(right+1) papars have
at least len-(righ+1) citations)

TC : o(logn)
SC :o(1)
 */
public class HIndexII {
    public static void main(String[] args) {
        int[] cit = new int[]{0,1,3,5,6};
        System.out.println(new HIndexII().hIndex(cit));

    }
    public int hIndex(int[] citations) {
        int l=0, r = citations.length-1, len = citations.length;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(citations[mid]== len - mid)
                return citations[mid];
            else if(citations[mid] > len-mid)
                r = mid -1;
            else
                l = mid+1;
        }

        return len -(r+1);
    }

}
