package com.string.manipulation;

import java.util.ArrayList;

/*
Easy Task
https://practice.geeksforgeeks.org/problems/c928f229cc972671d91c5e9f6b222414912cc88a/1

Given a string s whose length is n and array queries of length q where each elements of queries is either of type 1 query or type 2 query which is explained ahead.

There are two types of query.

Query type 1 : ["1",ind,char]  "1" denotes this is type 1 query. In this query you have to change the character
at index ind in s to character char.(Data type of ind,char is string in input)

Query Type 2: ["2",left,right,k]  "2" denotes this is type 2 query. In this query you have to return kth
lexographically largest character  in the subtring of s (it is the kth largest character in sorted order ,
not the kth distinct character) starting from index left and ending at index right both left and right are inclusive.
 (Data type of left,right,k is string in input)

You have to perform each query in the same order as given in  queries and return an array res such that res array
contains the answer for each type2 query in same order as it appeared in queries.

Note : 0 based indexing is used.

Example 1:

Input:
n=4
s="abab"
q=2
queries={{"1","2","d"},{"2","1","3","1"}}
Output:
{"d"}
Explanation:
First query is of type 1 so after changing character at index 2
to d  s becomes abdb . Now Second query is of type 2 in which
the 1st(k=1) lexographically largest character is "d" in substring "bdb"(s[1:3]). So we
returned a array with result of type 2 query {"d"}.

Expected Time Complexity: O(N+(Q*logN))
Expected Space Complexity: O(N)
 */
public class EasyTask {

    public static void main(String[] args) {
        query q[] = new query[]{
                new query("1","2","d", null),new query("2","1","3","1")
        };
        System.out.println(new EasyTask().easyTask(4,"abab",2, q));
    }
    public  ArrayList<Character> easyTask(int n, String s, int q, query queries[])
    {
        ArrayList<Character> list=new ArrayList<>();
        for(int i=0;i<q; i++){
            if("1".equals(queries[i].type)){
                s = getType1(s,Integer.parseInt(queries[i].a), queries[i].b.charAt(0));
            }
            else{
                list.add(getType2(s, Integer.parseInt(queries[i].a), Integer.parseInt(queries[i].b)
                        , Integer.parseInt(queries[i].c)));
            }
        }
        return list;
    }

    private  String getType1(String s, int i, char c){
        return s.substring(0,i)+c+s.substring(i+1);
    }

    private  char getType2(String s, int left, int right, int k)
    {
        int[] freq = new int[26];
        for(int i=left; i<=right;i++){
            freq[s.charAt(i)-'a']++;
        }

        int count =0;

        for(int i=25;i>=0;i--){
            while(count<k && freq[i]>0){
                count++;
                freq[i]--;
            }
            if(count==k){
                return (char)((int)'a'+i);
            }
        }
        return 'a';
    }
}

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
