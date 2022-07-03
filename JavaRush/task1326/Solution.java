/*
Сортировка четных чисел из файла
*/
/**
 В этой задаче тебе нужно:
 Ввести имя файла с консоли.
 Прочитать из него набор чисел.
 Вывести в консоли только четные, отсортированные по возрастанию.
 Пример ввода:
 5
 8
 -2
 11
 3
 -5
 2
 10

 Пример вывода:
 -2
 2
 8
 10

 Требования:
 •	Программа должна считывать данные с консоли.
 •	Программа должна создавать FileInputStream для введенной с консоли строки.
 •	Программа должна выводить данные на экран.
 •	Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
 •	Программа должна закрывать поток чтения из файла — FileInputStream.
 */

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();

        FileInputStream input = new FileInputStream(fileName);

        Scanner scanner = new Scanner(input);

        ArrayList<Integer> list = new ArrayList<>();

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        for (Integer i : list) {
            if (i % 2 == 0)
                System.out.println(i);
        }
        input.close();
        scanner.close();
    }
}