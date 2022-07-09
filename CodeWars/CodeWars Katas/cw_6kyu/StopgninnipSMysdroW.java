package cw_6kyu;

/*
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces.
Spaces will be included only when more than one word is present.

Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
 */

public class StopgninnipSMysdroW {

    public String spinWords(String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            if (s.length() >= 5) {
                StringBuilder tmp = new StringBuilder(s);
                tmp.reverse();
                result.append(tmp).append(" ");
            }
            else result.append(s).append(" ");
        }
        return result.toString().trim();
    }
}
