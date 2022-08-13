package com.design;

import java.util.HashMap;
import java.util.Map;

/*
2227. Encrypt and Decrypt Strings
You are given a character array keys containing unique characters and a string array values containing
strings of length 2. You are also given another string array dictionary that contains all permitted
original strings after decryption. You should implement a data structure that can encrypt or decrypt
a 0-indexed string.

A string is encrypted with the following process:

For each character c in the string, we find the index i satisfying keys[i] == c in keys.
Replace c with values[i] in the string.
Note that in case a character of the string is not present in keys, the encryption process cannot
be carried out, and an empty string "" is returned.

A string is decrypted with the following process:

For each substring s of length 2 occurring at an even index in the string, we find an
i such that values[i] == s. If there are multiple valid i, we choose any one of them.
This means a string could have multiple possible strings it can decrypt to.
Replace s with keys[i] in the string.
Implement the Encrypter class:

Encrypter(char[] keys, String[] values, String[] dictionary) Initializes the Encrypter class
with keys, values, and dictionary.
String encrypt(String word1) Encrypts word1 with the encryption process described above and
returns the encrypted string.
int decrypt(String word2) Returns the number of possible strings word2 could decrypt to that
also appear in dictionary.


Example 1:

Input
["Encrypter", "encrypt", "decrypt"]
[[['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]],
["abcd"], ["eizfeiam"]]
Output
[null, "eizfeiam", 2]

Explanation
Encrypter encrypter = new Encrypter([['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"],
                                    ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]);
encrypter.encrypt("abcd"); // return "eizfeiam".
                           // 'a' maps to "ei", 'b' maps to "zf", 'c' maps to "ei", and 'd' maps to "am".
encrypter.decrypt("eizfeiam"); // return 2.
                              // "ei" can map to 'a' or 'c', "zf" maps to 'b', and "am" maps to 'd'.
                              // Thus, the possible strings after decryption are "abad", "cbad", "abcd", and "cbcd".
                              // 2 of those strings, "abad" and "abcd", appear in dictionary, so the answer is 2.

Logic
-------
The hashmap enc help binding each paire of keys[i] and values[i],
so that we can encrypt a char to the string in O(1)

count counts the frequency of words in dictionary after encrypt,
then we can used in decrypt in O(1).


Complexity
Encrypter Time O(n) Space O(n)
encrypt Time O(word1) Space O(word1)
decrypt Time O(1) Space O(1)


Note
Not all word can be "encrypt",
For character c, if we can't find the index i satisfying keys[i] == c in keys.
The behavior are NOT clearly defined.

In my opinion we should do nothing but keep the original character,
(the standard solution of OJ doesn't work as I suggest)

These kind of test cases are not present in the original test cases set,
but recedntly blindly added to the test cases.

The descrption of probelm should be fixed, not blindly add an appropriat test cases.

It's like, a bug is reported and not guarded by tests,
then LC adds a test but not fix anything at all.
 */
public class EncryptAndDecryptStrings {
    public static void main(String[] args) {
        char[] keys = new char[]{'a', 'b', 'c', 'd'};
        String[] values =  new String[]{"ei", "zf", "ei", "am"};
        String[] dictionary = new String[]{"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};

        Encrypter obj = new Encrypter(keys, values, dictionary);
        String word1 = "abcd";
        System.out.println(obj.encrypt(word1));
        String word2 = "eizfeiam";
        System.out.println(obj.decrypt(word2));
    }

}

class Encrypter {

    Map<Character,String> enc;
    Map<String, Integer> count;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        enc = new HashMap<>();
        for(int i=0;i<keys.length;i++){
            enc.put(keys[i],values[i]);
        }

        count = new HashMap<>();

        for(String word : dictionary){
            String encryptedString =  encrypt(word);
            count.put(encryptedString, count.getOrDefault(encryptedString,0)+1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word1.length();i++){
            sb.append(enc.getOrDefault(word1.charAt(i),"#"));
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return count.getOrDefault(word2,0);
    }
}

