package com.string.manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
3606. Coupon Code Validator

You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:

code[i]: a string representing the coupon identifier.
businessLine[i]: a string denoting the business category of the coupon.
isActive[i]: a boolean indicating whether the coupon is currently active.
A coupon is considered valid if all of the following conditions hold:

code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
isActive[i] is true.
Return an array of the codes of all valid coupons, sorted first by their businessLine in the order:
"electronics", "grocery", "pharmacy", "restaurant",
and then by code in lexicographical (ascending) order within each category.



Example 1:

Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]

Output: ["PHARMA5","SAVE20"]

Explanation:

First coupon is valid.
Second coupon has empty code (invalid).
Third coupon is valid.
Fourth coupon has special character @ (invalid).

TC : o(nlogn)
SC: o(n)
 */
public class CouponCodeValidator {

    public static void main(String[] args) {
        System.out.println(new CouponCodeValidator().validateCoupons(
                new String[]{"SAVE20","","PHARMA5","SAVE@20"},
                new String[]{"restaurant","grocery","pharmacy","restaurant"},
                new boolean[] {true,true,true,true}
        ));
    }
    public List<String> validateCoupons(String[] code, String[] line, boolean[] active) {
        int n = code.length;

        Map<String, Integer> lineId = new HashMap<>();
        lineId.put("electronics", 1);
        lineId.put("grocery", 2);
        lineId.put("pharmacy", 3);
        lineId.put("restaurant", 4);

        List<Integer> valid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!lineId.containsKey(line[i]) || code[i] == null || code[i].isEmpty()) {
                active[i] = false;
            }
            if (active[i]) {
                for (char c : code[i].toCharArray()) {
                    if (!isGoodChar(c)) {
                        active[i] = false;
                        break;
                    }
                }
            }
            if (active[i]) {
                valid.add(i);
            }
        }

        valid.sort((i, j) -> {
            int li = lineId.get(line[i]);
            int lj = lineId.get(line[j]);
            if (li != lj) return Integer.compare(li, lj);
            return code[i].compareTo(code[j]);
        });

        List<String> ans = new ArrayList<>(valid.size());
        for (int idx : valid) {
            ans.add(code[idx]);
        }
        return ans;
    }
    private boolean isGoodChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }
}
