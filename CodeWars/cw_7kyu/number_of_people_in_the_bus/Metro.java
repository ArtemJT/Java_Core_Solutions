/**
You are provided with a list (or array) of integer pairs.
Elements of each pair represent number of people get into bus (The first item)
and number of people get off the bus (The second item) in a bus stop.

Your task is to return number of people who are still in the bus after the last bus station (after the last array).
Even though it is the last bus stop, the bus is not empty and some people are still in the bus,
and they are probably sleeping there :D

Take a look on the test cases.

Please keep in mind that the test cases ensure that the number of people in the bus is always >= 0.
So the return integer can't be negative.

The second value in the first integer array is 0, since the bus is empty in the first bus stop.
 */

import java.util.ArrayList;

public class Metro {
    public static int countPassengers(ArrayList<int[]> stops) {
        int result = 0;
        for (int[] ints : stops) {
            int in = ints[0];
            int out = ints[1];
            result += in - out;
        }
        return result;
    }
}