package com.graph.mst.krushkal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
2092. Find All People With Secret

You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed
2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting
at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.

Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then s
hared every time a meeting takes place with a person that has the secret. More formally, for every meeting,
if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.

The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in
other meetings within the same time frame.

Return a list of all the people that have the secret after all the meetings have taken place. You may return
the answer in any order.

Example 1:

Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
Output: [0,1,2,3,5]
Explanation:
At time 0, person 0 shares the secret with person 1.
At time 5, person 1 shares the secret with person 2.
At time 8, person 2 shares the secret with person 3.
At time 10, person 1 shares the secret with person 5.
Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.

Complexity Analysis:

Sorting takes O(MlogM) time.

Each meeting is visited and pushed into/popped out of ppl only once. For each visit, the connect/connected
takes amortized O(logN) time. So, traversing all the meetings takes O(MlogN) time.
Note that if we do union-by-rank, the time complexity can be reduced to O(M * alpha(N))
where alpha(N) is the inverse function of Ackermann function, and is even more efficient than logN.
But in LeetCode, the difference is negligible, so I usually just use path compression for simplicity.
It's definitly worth mentioning this knowledge during your interview though.

Lastly, traversing all the persons and checking connection with person 0 takes amortized O(NlogN) time.

So, overall the time complexity is amortized O(MlogM + (M + N) * logN), which can be reduced to
O(MlogM + (M + N) * alpha(N)) with union-by-rank.

As for space complexity, the Union Find takes O(N) space. The ppl array takes O(M) space in the worst case,
but it can be reduced to O(N) if we use unordered_set.
So, overall the (extra) space complexity is O(M + N) which can be reduced to O(N).
 */
public class FindAllPeopleWithSecret {

    public static void main(String[] args) {
        int n =6, firstPerson =1, meeting[][] = new int[][]{{1,2,5},{2,3,8},{1,5,10}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(n,meeting,firstPerson));
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // sort meeting in ascending order of time
        Arrays.sort(meetings, (a, b) -> a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        // let person-0 tells the secret to firstPerson
        // union takes place
        uf.union(0,firstPerson);
        int m = meetings.length;
        for(int i=0;i<m;){
            // get the time of a meeting
            int time = meetings[i][2];
            List<Integer> peopleList = new ArrayList<>();
            // make union of people attending all the parallel meeting
            // and add them to a list
            while(i<m && meetings[i][2]== time){
                uf.union(meetings[i][0],meetings[i][1]);
                peopleList.add(meetings[i][0]);
                peopleList.add(meetings[i][1]);
                i++;
            }

            // once we get the list, just check if a person belongs to same component as of person-0
            // if not, just reset that person so that that person can be considered in later time meeting
            for(int people : peopleList){
                if(uf.find(people)!= uf.find(0)){
                    uf.reset(people);
                }
            }
        }
        // once the above loop is done, all creation of components are done
        // so, just loop over all people and check whether a person belongs to same component as person-0
        // if yes, add to secretKnown group
        List<Integer> secretKnown = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(uf.find(i)==uf.find(0))
                secretKnown.add(i);
        }

        return secretKnown;
    }
}
