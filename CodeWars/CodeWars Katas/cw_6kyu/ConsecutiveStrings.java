package cw_6kyu;

/*
You are given an array(list) strarr of strings and an integer k.
Your task is to return the first longest string consisting of k consecutive strings taken in the array.

Examples:
strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2

Concatenate the consecutive strings of strarr by 2, we get:

treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]

Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
The first that came is "folingtrashy" so
longest_consec(strarr, 2) should return "folingtrashy".

In the same way:
longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
n being the length of the string array, if n = 0 or k > n or k <= 0 return ""
(return Nothing in Elm, "nothing" in Erlang).

Note
consecutive strings : follow one after another without an interruption
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

class ConsecutiveStrings {

    public static String longestConsec(String[] strarr, int k) {
        try {
            if (strarr.length < k) {
                return "";
            }
            int i = 0;
            LinkedHashMap <String, Integer> map = new LinkedHashMap <>();
            while ((i + k) <= strarr.length) {
                String[] s = Arrays.copyOfRange(strarr, i, i + k);
                String tmp = "";
                for (String str : s) {
                    tmp = tmp.concat(str);
                }
                map.put(tmp, tmp.length());
                i++;
            }
            int max = Collections.max(map.values());
            map.entrySet().removeIf(entry -> entry.getValue() < max);

            return map.entrySet().stream().filter(x -> x.getValue().equals(max)).findFirst().get().getKey();
        } catch (Exception e) {
            return "";
        }
    }
}
