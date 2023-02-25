package kolpakovee.controller;

import kolpakovee.models.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {
    @Test
    @DisplayName("Проверка, что при GET-запросе у пользователя появится книга")
    void process_GET_command_for_user_test_expected_return_equals() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();
        books.add(book);

        Library library = new Library(books);

        User user = new User();
        String bookName = "Как найти стажировку";

        CommandHandler.handle(Command.GET, library, user, bookName);

        assertEquals(book, user.getBooks().get(0));
    }

    @Test
    @DisplayName("Проверка, что при GET-запросе, если пользователь не возьмёт книгу, то вернётся false")
    void process_GET_command_test_expected_return_false() {
        List<Book> books = new ArrayList<>();
        Library library = new Library(books);

        User user = new User();
        String bookName = "Как найти стажировку";

        assertFalse(CommandHandler.handle(Command.GET, library, user, bookName));
    }

    @Test
    @DisplayName("Проверка, что при GET-запросе, если пользователь взял, то вернётся true")
    void process_GET_command_test_expected_return_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();
        books.add(book);

        Library library = new Library(books);

        User user = new User();
        String bookName = "Как найти стажировку";

        assertTrue(CommandHandler.handle(Command.GET, library, user, bookName));
    }

    @Test
    @DisplayName("Проверка, что при GET-запросе в бибилиотеке исчезнет книга")
    void process_GET_command_for_library_test_expected_return_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();
        books.add(book);

        Library library = new Library(books);

        User user = new User();
        String bookName = "Как найти стажировку";

        CommandHandler.handle(Command.GET, library, user, bookName);

        assertFalse(library.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь отдал книгу PUT-запросом, то обработчик вернёт true")
    void process_PUT_command_test_expected_return_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        assertTrue(CommandHandler.handle(Command.PUT, library, user, bookName));
    }

    @Test
    @DisplayName("Проверка, что если пользователь отдал книгу PUT-запросом, то она у него исчезнет")
    void process_PUT_command_for_user_test_expected_return_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        CommandHandler.handle(Command.PUT, library, user, bookName);

        assertFalse(user.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь отдал книгу PUT-запросом, то она появилась в библиотеке")
    void process_PUT_command_for_library_test_expected_return_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Как найти стажировку";

        CommandHandler.handle(Command.PUT, library, user, bookName);

        assertTrue(library.getBooks().contains(book));
    }

    @Test
    @DisplayName("Проверка, что если пользователь не отдал книгу PUT-запросом, то обработчик вернёт true")
    void process_PUT_command_test_expected_return_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        User user = new User();
        user.getBooks().add(book);

        String bookName = "Любая другая книга";

        assertFalse(CommandHandler.handle(Command.PUT, library, user, bookName));
    }
}