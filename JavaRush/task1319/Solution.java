import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Писатель в файл с консоли
*/
/**
 В этой задаче тебе нужно:
 Прочесть с консоли имя файла.
 Считывать строки с консоли, пока пользователь не введет строку "exit".
 Записать абсолютно все введенные в п.2 строки в файл: каждую строчку — с новой строки.
 Требования:
 •	Программа должна считывать c консоли имя файла.
 •	Создай и используй объект типа BufferedWriter.
 •	Программа не должна ничего считывать из файловой системы.
 •	Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
 •	Программа должна записать все введенные строки (включая "exit", но не включая имя файла) в файл:
    каждую строчку — с новой строки.
 •	Метод main должен закрывать объект типа BufferedWriter после использования.
 •	Метод main не должен выводить данные на экран.
 */

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();

        FileWriter fileWriter = new FileWriter(sourceFileName);
        BufferedWriter buffer = new BufferedWriter(fileWriter);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (string.equals("exit")) {
                buffer.write(string);
                break;
            }
            else {
                buffer.write(string);
                buffer.newLine();
            }
        }
        scanner.close();
        buffer.close();
    }
}