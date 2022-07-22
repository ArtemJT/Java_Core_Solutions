package cw_6kyu;

/*
Complete the solution so that it splits the string into pairs of two characters.
If the string contains an odd number of characters then it should replace
the missing second character of the final pair with an underscore ('_').

Examples:

* 'abc' =>  ['ab', 'c_']
* 'abcdef' => ['ab', 'cd', 'ef']
 */

public class SplitStrings {
    public static String[] solution(String s) {
        String[] result;
        if (s.length() %2 == 0) {
            result = s.replaceAll("(.{2})", "$1~").split("~");
        } else {
            result = s.concat("_").replaceAll("(.{2})", "$1~").split("~");
        }
        return result;
    }
}
