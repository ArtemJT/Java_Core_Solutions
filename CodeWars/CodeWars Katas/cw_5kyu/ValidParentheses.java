package cw_5kyu;

/*
Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
The function should return true if the string is valid, and false if it's invalid.

Examples
"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true
Constraints
0 <= input.length <= 100

Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
Furthermore, the input string may be empty and/or not contain any parentheses at all.
Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).


 */

public class ValidParentheses {

    public static boolean validParentheses(String parens) {
        StringBuilder builder = new StringBuilder();
        while (parens.contains("(") && parens.contains(")")) {
            int indexOpen = parens.indexOf("(");
            int indexClose = parens.indexOf(")");

            if (indexOpen < indexClose) {
                builder = new StringBuilder(parens.substring(indexOpen + 1, indexClose));
                builder.append(parens.substring(indexClose + 1));
            } else if (indexOpen > indexClose) {
                return false;
            }
            parens = builder.toString();
        }
        return !parens.contains("(") && !parens.contains(")");
    }
}
