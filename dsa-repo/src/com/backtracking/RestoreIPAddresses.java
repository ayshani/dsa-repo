package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
93. Restore IP Addresses

A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255
(inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses,
but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by
inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid
IP addresses in any order.

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

TC : o(N^N)
SC : o(N)

 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("101023"));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s,"", 0, result);
        return result;
    }

    private void backtrack(String s, String current, int count, List<String> result){
        if(s.isEmpty() || count==4){
            if(s.isEmpty() && count==4){
                result.add(current.substring(1));
            }
            return;
        }

        for(int i=1;i<=(s.charAt(0)=='0'? 1: 3) && i<=s.length();i++){
            String part = s.substring(0,i);
            if(Integer.valueOf(part)<=255){
                backtrack(s.substring(i),current+"."+part,count+1,result);
            }
        }
    }
}
