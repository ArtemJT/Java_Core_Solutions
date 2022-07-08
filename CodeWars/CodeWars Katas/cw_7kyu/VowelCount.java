package cw_7kyu;

/*
 Return the number (count) of vowels in the given string.

 We will consider a, e, i, o, u as vowels for this Kata (but not y).

 The input string will only consist of lower case letters and/or spaces.
 */

import java.util.HashSet;

public class VowelCount {
    public static int getCount(String str) {
        HashSet<Character> charSet = new HashSet<>(){{
            add('a'); add('e'); add('i'); add('o'); add('u');}};
        int vowelsCount = 0;
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }
}
