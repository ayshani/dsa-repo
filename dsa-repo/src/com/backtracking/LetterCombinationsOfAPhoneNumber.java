package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
any letters.

 Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

TC : o(4^n)
as max combination per digit, it can take upto 4 combination. and n for number of digits
SC : o(n)
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return result;

        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a','b','c'});
        map.put('3', new Character[]{'d','e','f'});
        map.put('4', new Character[]{'g','h','i'});
        map.put('5', new Character[]{'j','k','l'});
        map.put('6', new Character[]{'m','n','o'});
        map.put('7', new Character[]{'p','q','r','s'});
        map.put('8', new Character[]{'t','u','v'});
        map.put('9', new Character[]{'w','x','y','z'});

        util(digits, 0, "",result, map);
        return result;
    }

    private void util(String digits, int start, String current, List<String> result, Map<Character, Character[]> map ){
        if(current.length()== digits.length()){
            result.add(current);
            return;
        }

        Character[] temps = map.get(digits.charAt(start));
        for(char c : temps){
            current += c;
            util(digits, start+1, current, result, map);
            current = current.substring(0, current.length()-1);
        }
    }
}
