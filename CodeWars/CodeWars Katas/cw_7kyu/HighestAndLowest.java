package cw_7kyu;

/*
 In this little assignment you are given a string of space separated numbers,
 and have to return the highest and lowest number.

 Examples
 highAndLow("1 2 3 4 5")  // return "5 1"
 highAndLow("1 2 -3 4 5") // return "5 -3"
 highAndLow("1 9 3 4 -5") // return "9 -5"
 Notes
 All numbers are valid Int32, no need to validate them.
 There will always be at least one number in the input string.
 Output string must be two numbers separated by a single space, and highest number is first.

 */

import java.util.Arrays;

public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        if (numbers.length() > 1) {
            String[] strings = numbers.split(" ");
            int[] ints = new int[strings.length];
            for (int i = 0, j = 0; i < strings.length; i++, j++) {
                ints[j] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(ints);
            return String.format("%d %d", ints[ints.length -1] ,ints[0]);
        }
        return numbers;
    }
}
