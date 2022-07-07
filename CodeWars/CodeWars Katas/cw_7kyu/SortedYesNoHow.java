package cw_7kyu;

/**
 Complete the method which accepts an array of integers, and returns one of the following:

 "yes, ascending" - if the numbers in the array are sorted in an ascending order
 "yes, descending" - if the numbers in the array are sorted in a descending order
 "no" - otherwise
 You can assume the array will always be valid, and there will always be one correct answer.

 */

import java.util.Arrays;

public class SortedYesNoHow {
    public static String isSortedAndHow(int[] array) {
        int[] arraySorted = Arrays.copyOf(array,array.length);
        Arrays.sort(arraySorted);

        int[] arrayReverse = new int[arraySorted.length];
        for (int i = arraySorted.length -1, j = 0; i >= 0; i--, j++) {
            arrayReverse[j] = arraySorted[i];
        }

        if (Arrays.equals(array, arraySorted)) {
            return "yes, ascending";
        } else if (Arrays.equals(array, arrayReverse)) {
            return "yes, descending";
        }
        return "no";
    }
}
