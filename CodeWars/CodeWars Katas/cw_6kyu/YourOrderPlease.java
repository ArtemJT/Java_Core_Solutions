package cw_6kyu;

/*
Your task is to sort a given string. Each word in the string will contain a single number.
This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string.
The words in the input String will only contain valid consecutive numbers.

Examples
"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""
 */

import java.util.HashMap;

public class YourOrderPlease {
    public static String order(String words) {
        String result = "";
        String[] stringsArray = words.split(" ");
        HashMap<Integer, String> map = new HashMap<>();
        for (String s : stringsArray) {
            if (s.contains("1")) {
                map.put(1, s);
            } else if (s.contains("2")) {
                map.put(2, s);
            } else if (s.contains("3")) {
                map.put(3, s);
            } else if (s.contains("4")) {
                map.put(4, s);
            } else if (s.contains("5")) {
                map.put(5, s);
            } else if (s.contains("6")) {
                map.put(6, s);
            } else if (s.contains("7")) {
                map.put(7, s);
            } else if (s.contains("8")) {
                map.put(8, s);
            } else if (s.contains("9")) {
                map.put(9, s);
            }
        }
        for (String s : map.values()) {
            result += s + " ";
        }
        return result.trim();
    }
}
