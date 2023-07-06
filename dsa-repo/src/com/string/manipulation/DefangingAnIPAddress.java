package com.string.manipulation;
/*
1108. Defanging an IP Address

Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".



Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

TC : o(n)
SC: o(1)
 */
public class DefangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(new DefangingAnIPAddress().defangIPaddr("255.100.50.0"));
    }
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<address.length();i++){
            sb.append(address.charAt(i)=='.'? "[.]" : address.charAt(i));
        }
        return sb.toString();

    }
}
