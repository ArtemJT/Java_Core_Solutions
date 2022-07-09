package cw_6kyu;

/*
Your goal in this kata is to implement a difference function,
which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> intList = new ArrayList<>() {{ for (int i : a) add(i); }};
        List<Integer> intList2 = new ArrayList<>() {{ for (int i : b) add(i); }};
        intList.removeAll(intList2);
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }
}
