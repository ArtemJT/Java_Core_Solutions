package cw_6kyu;

/*
Build Tower
Build a pyramid-shaped tower given a positive integer number of floors.
A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]
And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */

public class BuildTower
{
    public static String[] towerBuilder(int nFloors) {
        String[] result = new String[nFloors];
        String s;
        for (int i = 0; i < nFloors; i++)
            result[i] = (s = " ".repeat(nFloors-i-1)) + "*".repeat(i+i+1) + s;
        return result;
    }
}
