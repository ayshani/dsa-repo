package com.graph.mst.krushkal;

import java.util.Arrays;

/*
1101. The Earliest Moment When Everyone Become Friends

There are n people in a social group labeled from 0 to n - 1. You are given an array logs where
logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.

Friendship is symmetric. That means if a is friends with b, then b is friends with a.
Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person.
If there is no such earliest time, return -1.

Input: logs = [[20190101,0,1],[20190104,3,4],
                [20190107,2,3],[20190211,1,5],
                [20190224,2,4],[20190301,0,3],
                [20190312,1,2],[20190322,4,5]],
                 n = 6
Output: 20190301
Explanation:
The first event occurs at timestamp = 20190101, and after 0 and 1 become friends, we have the following
    friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104, and after 3 and 4 become friends, we have the following
    friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107, and after 2 and 3 become friends, we have the following
    friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211, and after 1 and 5 become friends, we have the following
    friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224, and as 2 and 4 are already friends, nothing happens.
The sixth event occurs at timestamp = 20190301, and after 0 and 3 become friends, we all become friends.

// O(M*log(M) + N + M) == O(M*log(M)) time where M == logs.length.
Note that we assume that Union-Find unions take O(1) time in practice, in theory it's very sligthly above O(1).
// O(N) space.
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {

    public static void main(String[] args) {
        int[][] logs = new int[][]{
                {20190101,0,1},{20190104,3,4},
                {20190107,2,3},{20190211,1,5},
                {20190224,2,4},{20190301,0,3},
                {20190312,1,2},{20190322,4,5}
        };

        System.out.println(new TheEarliestMomentWhenEveryoneBecomeFriends().earliestAcq(logs,6));
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0]-b[0]);
        UnionFind uf = new UnionFind(n);
        for(int[] log : logs){
            uf.union(log[1],log[2]);
            // once we get all connected edges in one component
            // we return the timestamp. and we don't look any further
            if(uf.count==1){
                return log[0];
            }
        }
        return -1;
    }
}
