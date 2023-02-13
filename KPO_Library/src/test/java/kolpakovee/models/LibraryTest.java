package kolpakovee.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    @DisplayName("Проверяем получим ли мы список книг, содержащих одинаковое слово в названии")
    void get_books_by_name_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book1 = new Book("Как найти стажировку", "", authors, 2023);
        Book book2 = new Book("Как найти нормально джуна", "", authors, 2023);
        Book book3 = new Book("Поиск работы за месяц", "", authors, 2023);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Library library = new Library(books);

        List<Book> bookList = library.getBooksByName("найти");

        List<Book> resultList = new ArrayList<>();
        resultList.add(book1);
        resultList.add(book2);

        assertEquals(bookList, resultList);
    }

    @Test
    @DisplayName("Проверяем исчезнет ли книга из библиотеки")
    void get_book_from_library_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();
        books.add(book);

        Library library = new Library(books);

        library.getBook(book);

        assertEquals(library.getBooks().size(), 0);
    }

    @Test
    @DisplayName("Проверяем, добавится ли книга в библиотеку")
    void put_book_to_library_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        library.putBook(book);

        List<Book> resultList = new ArrayList<>();
        resultList.add(book);

        assertEquals(books, resultList);
    }
}