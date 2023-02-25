package kolpakovee.controller;

import kolpakovee.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {
    @Test
    @DisplayName("Проверка, что если пользователь не взял книгу, то метод getBookByName вернёт false")
    void user_did_not_take_book_getBookByName_test_expected_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);
        library.getBooks().add(book);

        User user = new User();
        String bookName = "Любая другая книга";

        assertFalse(LibraryManager.getBookByName(user, library, bookName));
    }

    @Test
    @DisplayName("Проверка, что если пользователь взял книгу, то метод getBookByName вернёт true")
    void user_take_book_getBookByName_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);
        library.getBooks().add(book);

        User user = new User();
        String bookName = "Как найти стажировку";

        assertTrue(LibraryManager.getBookByName(user, library, bookName));
    }

    @Test
    @DisplayName("Проверка, что если пользователь взял книгу, то она у него появилась")
    void user_take_book_getBookByName_for_user_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);
        library.getBooks().add(book);

        User user = new User();
        String bookName = "Как найти стажировку";

        LibraryManager.getBookByName(user, library, bookName);

        assertTrue(user.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь взял книгу, то она исчезла в библиотеке")
    void user_take_book_getBookByName_for_library_test_expected_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);
        library.getBooks().add(book);

        User user = new User();
        String bookName = "Как найти стажировку";

        LibraryManager.getBookByName(user, library, bookName);

        assertFalse(library.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь не вернул книгу, то метод putBookByName вернёт false")
    void user_did_not_put_book_putBookByName_test_expected_false() {
        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        String bookName = "Любая книга";

        assertFalse(LibraryManager.putBookByName(user, library, bookName));
    }

    @Test
    @DisplayName("Проверка, что если пользователь вернул книгу, то метод putBookByName вернёт true")
    void user_put_book_putBookByName_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        assertTrue(LibraryManager.putBookByName(user, library, bookName));
    }

    @Test
    @DisplayName("Проверка, что если пользователь вернул книгу, то она у него исчезнет")
    void user_put_book_putBookByName_for_user_test_expected_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        LibraryManager.putBookByName(user, library, bookName);

        assertFalse(user.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь вернул книгу, то метод она появится в библиотеке")
    void user_put_book_putBookByName_for_library_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        LibraryManager.putBookByName(user, library, bookName);

        assertTrue(library.getBooks().contains(book));
    }
}