package cw_6kyu;

/*
You are given an array (which will have a length of at least 3, but could be very large) containing integers.
The array is either entirely comprised of odd integers
or entirely comprised of even integers except for a single integer N.
Write a method that takes the array as an argument and returns this "outlier" N.

Examples
[2, 4, 0, 100, 4, 11, 2602, 36]
Should return: 11 (the only odd number)

[160, 3, 1719, 19, 11, 13, -21]
Should return: 160 (the only even number)
 */

public class FindTheParityOutlier {
    static int find(int[] integers){
        int odd = 0;
        int even = 0;
        for (int i : integers) {
            if (i % 2 != 0) {
                odd++;
            }
            else even++;
        }
        for (int i : integers) {
            if (odd == 1) {
                if (i %2 != 0) return i;
            } else if (even == 1) {
                if (i %2 == 0) return i;
            }
        }
        return 0;
    }
}
/*
    int[] odd = Arrays.stream(integers).filter(n -> n % 2 != 0).toArray();
    int[] even = Arrays.stream(integers).filter(n -> n % 2 == 0).toArray();

    return odd.length == 1 ? odd[0] : even[0];
 */