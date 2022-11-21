package cw_4kyu;

/*
Example:

Given an input string of:

apples, pears # and bananas
grapes
bananas !apples
The output expected would be:

apples, pears
grapes
bananas
The code would be called like so:

var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// result should == "apples, pears\ngrapes\nbananas"
 */

import java.util.StringJoiner;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        String regex = "\n";
        StringJoiner joiner = new StringJoiner(regex);
        String[] strings = text.split(regex);
        for (String string : strings) {
            for (String tag : commentSymbols) {
                char tilde = '~';
                string = string.replace(tag.charAt(0), tilde);
                if (string.contains(Character.toString(tilde))) {
                    string = string.replaceAll(tilde + ".*", "");
                }
            }
            joiner.add(string.stripTrailing());
        }
        return joiner.toString();
    }
}
