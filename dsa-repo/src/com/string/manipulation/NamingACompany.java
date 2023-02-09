package com.string.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
2306. Naming a Company

You are given an array of strings ideas that represents a list of names to be used in the process of naming a company. The process of naming a company is as follows:

Choose 2 distinct names from ideas, call them ideaA and ideaB.
Swap the first letters of ideaA and ideaB with each other.
If both of the new names are not found in the original ideas, then the name ideaA ideaB
(the concatenation of ideaA and ideaB, separated by a space) is a valid company name.
Otherwise, it is not a valid name.
Return the number of distinct valid names for the company.



Example 1:

Input: ideas = ["coffee","donuts","time","toffee"]
Output: 6
Explanation: The following selections are valid:
- ("coffee", "donuts"): The company name created is "doffee conuts".
- ("donuts", "coffee"): The company name created is "conuts doffee".
- ("donuts", "time"): The company name created is "tonuts dime".
- ("donuts", "toffee"): The company name created is "tonuts doffee".
- ("time", "donuts"): The company name created is "dime tonuts".
- ("toffee", "donuts"): The company name created is "doffee tonuts".
Therefore, there are a total of 6 distinct company names.

The following are some examples of invalid selections:
- ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
- ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
- ("coffee", "toffee"): Both names formed after swapping already exist in the original array.

Explanation
Any idea = first letter + postfix string.
We can group all ideas by their first letter.

If two ideas ideas[i] and ideas[j] share a common postfix string,
then ideas[i] can not pair with any idea starts with ideas[j][0]
and ideas[j] can not pair with any idea starts with ideas[i][0].


Complexity
Time O(n)
Space O(n)
 */
public class NamingACompany {

    public static void main(String[] args) {
        System.out.println(new NamingACompany().distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for(int i=0;i<26;i++){
            set[i] = new HashSet<>();
        }

        for(String idea : ideas){
            set[idea.charAt(0)-'a'].add(idea.substring(1));
        }
        long result =0;
        for(int i=0;i<26;i++){
            for(int j= i+1; j<26;j++){
                int counti =0, countj=0;

                for(String c : set[i]){
                    if(!set[j].contains(c))
                        counti++;
                }

                for(String c : set[j]){
                    if(!set[i].contains(c))
                        countj++;
                }

                result+= counti*countj;
            }
        }
        return result*2;
    }
}
