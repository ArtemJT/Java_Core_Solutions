package cw_5kyu;

/*
Move the first letter of each word to the end of it, then add "ay" to the end of the word.
Leave punctuation marks untouched.

Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !
 */

public class SimplePigLatin {
    public static String pigIt(String str) {
        String[] strArray = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strArray) {
            stringBuilder.append(replace1stChar(s)).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    private static String replace1stChar(String str) {
        if (!str.matches("\\W")) {
            StringBuilder builder = new StringBuilder();
            char[] charArray = str.toCharArray();
            for (int i = 1; i < charArray.length; i++) {
                builder.append(charArray[i]);
            }
            return builder.append(charArray[0]).append("ay").toString();
        }
        return str;
    }
}
