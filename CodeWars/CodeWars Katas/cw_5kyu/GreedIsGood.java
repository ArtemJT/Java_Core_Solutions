package cw_5kyu;

/*
Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it,
is to score a throw according to these rules. You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point

A single die can only be counted once in each roll.
For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points,
but not both in the same roll.

Example scoring

 Throw       Score
 ---------   ------------------
 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
In some languages, it is possible to mutate the input to the function. This is something that you should never do.
If you mutate the input, you will not be able to pass all the tests.

 */

import java.util.Arrays;

public class GreedIsGood {
    public static int greedy(int[] dice){
        int result = 0;
        int[] count = new int[6];
        for (int i = 0; i < count.length; i++) {
            int FINAL = i + 1;
            count[i] = (int) Arrays.stream(dice).filter(x -> x == FINAL).count();
        }
        switch (count[0]) {//1
            case 5 -> result += 1000 + 100 * 2;
            case 4 -> result += 1000 + 100;
            case 3 -> result += 1000;
            case 1 -> result += 100;
            case 2 -> result += 100 * 2;
        }
        switch (count[4]) {//5
            case 5 -> result += 500 + 50 * 2;
            case 4 -> result += 500 + 50;
            case 3 -> result += 500;
            case 1 -> result += 50;
            case 2 -> result += 50 * 2;
        }

        if (count[1] >= 3) {//2
            result += 200;
        }
        else if (count[2] >= 3) {//3
            result += 300;
        }
        else if (count[3] >= 3) {//4
            result += 400;
        }
        else if (count[5] >= 3) {//6
            result += 600;
        }

        return result;
    }
}
