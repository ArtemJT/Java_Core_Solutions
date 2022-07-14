package cw_6kyu;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string is "("
if that character appears only once in the original string, or ")"
if that character appears more than once in the original string. Ignore capitalization when determining
if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
Notes
Assertion messages may be unclear about what they display in some languages.
If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!
 */

import java.util.HashSet;

public class DuplicateEncoder {
    static String encode(String word){
        String str = "";
        HashSet<Character> duplicateSet = new HashSet<>();
        char[] chars = word.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) { //   || chars[i] == ' '
                        duplicateSet.add(chars[i]);
                    }
                }
            }
        for (char aChar : chars) {
            str += duplicateSet.contains(aChar) ? ")" : "(";
        }
        return str;
    }
}
