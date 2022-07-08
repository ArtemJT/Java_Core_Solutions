package cw_8kyu;

/*
 Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

 Example(Input => Output):
 348597 => [7,9,5,8,4,3]
 0 => [0]
 */

public class ConvertNumberToReversedArrayOfDigits {
    public static int[] digitize(long n) {
        if (n > 0) {
            char[] chars = String.valueOf(n).toCharArray();
            int[] ints = new int[chars.length];
            for (int i = 0, j = ints.length - 1; i < chars.length; i++, j--) {
                ints[j] = Character.getNumericValue(chars[i]);
            }
            return ints;
        }
        return new int[]{0};
    }
}
