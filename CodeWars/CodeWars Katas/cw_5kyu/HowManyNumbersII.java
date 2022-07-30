package cw_5kyu;

/*
We want to find the numbers higher or equal than 1000 that the sum of every four consecutives digits cannot be higher than a certain given value.
If the number is num = d1d2d3d4d5d6, and the maximum sum of 4 contiguous digits is maxSum, then:

d1 + d2 + d3 + d4 <= maxSum
d2 + d3 + d4 + d5 <= maxSum
d3 + d4 + d5 + d6 <= maxSum
For that purpose, we need to create a function, max_sumDig(), that receives nMax,
as the max value of the interval to study (the range (1000, nMax) ), and a certain value, maxSum,
the maximum sum that every four consecutive digits should be less or equal to. The function should output the following list with the data detailed bellow:

[(1), (2), (3)]

(1) - the amount of numbers that satisfy the constraint presented above

(2) - the closest number to the mean of the results, if there are more than one, the smallest number should be chosen.

(3) - the total sum of all the found numbers

Let's see a case with all the details:

max_sumDig(2000, 3) -------> [11, 1110, 12555]

(1) -There are 11 found numbers: 1000, 1001, 1002, 1010, 1011, 1020, 1100, 1101, 1110, 1200 and 2000

(2) - The mean of all the found numbers is:
      (1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000) /11 = 1141.36363,
      so 1110 is the number that is closest to that mean value.

(3) - 12555 is the sum of all the found numbers
      1000 + 1001 + 1002 + 1010 + 1011 + 1020 + 1100 + 1101 + 1110 + 1200 + 2000 = 12555

Finally, let's see another cases
max_sumDig(2000, 4) -----> [21, 1120, 23665]

max_sumDig(2000, 7) -----> [85, 1200, 99986]

max_sumDig(3000, 7) -----> [141, 1600, 220756]

```

Happy coding!!
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbersII {

    public static long[] maxSumDig(long nmax, int maxsm) {
        List<Long> numberList = getNumbersList(nmax, maxsm);
        long res1 = numberList.size();
        long res3 = numberList.stream().mapToLong(x -> x).sum();
        long res2 = getNumber2(res1, res3, numberList);
        return new long[]{res1, res2, res3};
    }

    private static long getNumber2(long res1, long res3, List<Long> numberList) {
        long tmp = res3 / res1;
        long tmp1 = numberList.stream().filter(x -> x <= res3 / res1).max(Long::compareTo).get();
        long tmp2 = numberList.stream().filter(x -> x >= res3 / res1).min(Long::compareTo).get();
        return (tmp - tmp1) < (tmp2 - tmp) ? tmp1 : tmp2;
    }

    private static List<Long> getNumbersList(long nmax, int maxsm) {
        List<Long> numbersList = new ArrayList<>();
        while (nmax >= 1000) {
            if (nmax > 9999) {
                long i = nmax / 10;
                long j = nmax % 10000;
                String[] digitsI = Long.toString(i).split("");
                String[] digitsJ = Long.toString(j).split("");
                long sumI = Arrays.stream(digitsI).mapToLong(Long::parseLong).sum();
                long sumJ = Arrays.stream(digitsJ).mapToLong(Long::parseLong).sum();
                if (sumI <= maxsm && sumJ <= maxsm) {
                    numbersList.add(nmax);
                }
            } else {
                String[] digits = Long.toString(nmax).split("");
                long sum = Arrays.stream(digits).mapToLong(Long::parseLong).sum();
                if (sum <= maxsm) {
                    numbersList.add(nmax);
                }
            }
            nmax--;
        }
        return numbersList;
    }
}
