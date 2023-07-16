package com.dp;

import java.util.*;

/*
1125. Smallest Sufficient Team

In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i]
contains a list of skills that the person has.

Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least
one person in the team who has that skill. We can represent these teams by the index of each person.

For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
Return any sufficient team of the smallest possible size, represented by the index of each person. You may return
the answer in any order.

It is guaranteed an answer exists.



Example 1:

Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]
Example 2:

Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],
["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
Output: [1,2]

Complexity
Time O(people * 2^skill)
Space O(2^skill)
 */
public class SmallestSufficientTeam {

    public static void main(String[] args) {
        String[]  req = new String[]{"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        people.add(Arrays.asList("java"));
        people.add(Arrays.asList("nodejs"));
        people.add(Arrays.asList("nodejs","reactjs"));

        System.out.println(Arrays.toString(new SmallestSufficientTeam().smallestSufficientTeam(req,people)));
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        /*
        First creates a map of skills to skill index,
        so that it can quickly look up which skill corresponds to which index.

        We use the bit mask to represent a skills set.
        req_skills[0] is 1 << 0
        req_skills[i] is 1 << 1
        req_skills[n - 1] is 1 << (n - 1)
        Then a skills set can be expressed as an integer bit mask.
        */
        Map<String,Integer> skillsIndexMap = new HashMap<>();
        for(int i=0;i<n;i++){
            skillsIndexMap.put(req_skills[i],i);
        }
        /*
        Then creates a hashmap dp for size 1 << n.
         dp[skills] will contain the indices of the people required to satisfy the skills.
        */
        List<Integer>[] dp = new List[1<<n];
        dp[0]= new ArrayList<>();
        //We loops through the people
        for(int i=0;i<m;i++){
            //for each person, find his cur_skill bit mask.
            int curSkill =0;
            for(String skill : people.get(i)){
                curSkill  = curSkill | (1<<skillsIndexMap.get(skill));
            }
            //Then we check all dp[prev] in the existing dp.
            for(int prev =0; prev< dp.length;prev++){
                if(dp[prev]== null)
                    continue;
                //we combine the new skills comb = prev | cur_skill
                int combination = prev |  curSkill;
                //and then check if dp[comb] not found or dp[comb].size() > 1 + dp[prev].size(),
                //then we can update dp[comb] by dp[prev] + [this person]
                if(dp[combination]== null || dp[prev].size() +1 < dp[combination].size()){
                    dp[combination] = new ArrayList<>(dp[prev]);
                    dp[combination].add(i);
                }
            }
        }
        /*
        We continuly do this and finally,
        returns the indices of the people dp[(1 << n) - 1] with all skills covered.
        */
        return dp[(1<<n)-1].stream().mapToInt(i->i).toArray();
    }
}
