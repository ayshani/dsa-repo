package com.string.manipulation;
/*
Reverse String With Space
---------------------------

e.g. :     i am good
reverse :  d oo gmai

TC : o(n)
SC: o(1)
 */
public class ReverseStringWithSpace {

    public static void main(String[] args) {
        System.out.println(new ReverseStringWithSpace().reverse("I am good"));
        //System.out.println(new ReverseStringWithSpace().reverse("I"));
        //System.out.println(new ReverseStringWithSpace().reverse(""));
        System.out.println(new ReverseStringWithSpace().reverse(" "));
    }
    public String reverse(String s){
        if(s== null && s.length()==0)
            return "";
        int i=0, j = s.length()-1;
        char[] cur = s.toCharArray();
        while(i<j){
            if(cur[i]==' '){
                i++;
            }
            if(cur[j]==' '){
                j--;
            }
            char temp = cur[i];
            cur[i] = cur[j];
            cur[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(cur);
    }
}
