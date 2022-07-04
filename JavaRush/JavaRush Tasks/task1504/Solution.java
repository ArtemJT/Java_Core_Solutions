package task1504;/*
ООП - книги
*/
/**
 Давай напишем программу, которая будет определять жанр книги, или автора, который ее написал.
 Для этого:
 Создай public static класс MarkTwainBook, который наследуется от Book. Имя автора — [Mark Twain].
 Параметр конструктора — название книги (title).
 В классе MarkTwainBook реализуй все абстрактные методы.
 Для метода getBook измени тип возвращаемого значения на более подходящий.
 Создай по аналогии AgathaChristieBook. Имя автора — [Agatha Christie].
 В классе Book реализуй тело метода getOutputByBookType() так, чтобы он возвращал:
 agathaChristieOutput — для книг Агаты Кристи;
 markTwainOutput — для книг Марка Твена.
 Требования:
 •	Класс Solution должен содержать public static класс MarkTwainBook.
 •	Класс MarkTwainBook должен быть потомком класса Book.
 •	В классе MarkTwainBook должен быть корректно реализован конструктор с одним параметром типа String (название книги).
 •	Конструктор класса MarkTwainBook должен вызывать конструктор класса предка (Book) с параметром "Mark Twain".
 •	Метод getBook в классе MarkTwainBook должен иметь тип возвращаемого значения MarkTwainBook и возвращать текущий объект.
 •	Класс Solution должен содержать public static класс AgathaChristieBook.
 •	Класс AgathaChristieBook должен быть потомком класса Book.
 •	В классе AgathaChristieBook должен быть корректно реализован конструктор с одним параметром типа String (название книги).
 •	Конструктор класса AgathaChristieBook должен вызывать конструктор класса предка (Book) с параметром "Agatha Christie".
 •	Метод getBook в классе AgathaChristieBook должен иметь тип возвращаемого значения AgathaChristieBook и возвращать текущий объект.
 •	Метод getTitle в классах AgathaChristieBook и MarkTwainBook должен возвращать название конкретной книги.
 •	Метод getOutputByBookType должен возвращать корректную строку для объектов типа AgathaChristieBook.
 •	Метод getOutputByBookType должен возвращать корректную строку для объектов типа MarkTwainBook.
 •	В классе MarkTwainBook должно быть создано поле title типа String (название книги).
 •	В классе AgathaChristieBook должно быть создано поле title типа String (название книги).
 */

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            //Add your code here
            if (author.equalsIgnoreCase("Mark Twain")) {
                return markTwainOutput; }
            if (author.equalsIgnoreCase("Agatha Christie")) {
                return agathaChristieOutput; }

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book {
        String title;

        public MarkTwainBook(String author) {
            super("Mark Twain");
            this.title = author;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }

    public static class AgathaChristieBook extends Book {
        String title;

        public AgathaChristieBook(String author) {
            super("Agatha Christie");
            this.title = author;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return title;
        }
    }
}