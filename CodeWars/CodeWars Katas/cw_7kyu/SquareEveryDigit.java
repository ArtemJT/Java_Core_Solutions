package cw_7kyu;

/*
 Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

 For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

 Note: The function accepts an integer and returns an integer
 */

public class SquareEveryDigit {

    public int squareDigits(int n) {
        if (n > 0) {
            String str = Integer.toString(n);
            StringBuilder s = new StringBuilder();
            for (char c : str.toCharArray()) {
                s.append((int) Math.pow(Integer.parseInt(String.valueOf(c)), 2));
            }
            return Integer.parseInt(s.toString());
        }
        return 0;
    }
}