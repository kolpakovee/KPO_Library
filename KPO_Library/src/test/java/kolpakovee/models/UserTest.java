package kolpakovee.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Проверяет, что книга исчезла из списка книг пользователя")
    void return_book_to_library_test_expected_true() {
        User user = new User();

        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        Library library = new Library(books);

        user.getBooks().add(book);

        user.returnBook(user.getBooks().get(0), library);

        assertEquals(user.getBooks().size(), 0);
    }

    @Test
    @DisplayName("Проверяет, появилась ли книга у пользователя")
    void get_book_from_library_test_expected_true() {
        User user = new User();

        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));

        Book book = new Book("Как найти стажировку", "", authors, 2023);

        List<Book> books = new ArrayList<>();

        books.add(book);

        Library library = new Library(books);

        user.getBookFromLibrary(library, book);

        List<Book> resultList = new ArrayList<>();

        resultList.add(book);

        assertEquals(user.getBooks(), resultList);
    }

    @Test
    @DisplayName("Проверяем, получим ли мы список всех книг пользователя, содержащих одинаковое слово в названии")
    void get_books_by_name_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book1 = new Book("Как найти стажировку", "", authors, 2023);
        Book book2 = new Book("Как найти нормально джуна", "", authors, 2023);
        Book book3 = new Book("Поиск работы за месяц", "", authors, 2023);

        User user = new User();

        user.getBooks().add(book1);
        user.getBooks().add(book2);
        user.getBooks().add(book3);

        List<Book> bookList = user.getBooksByName("найти");

        List<Book> resultList = new ArrayList<>();
        resultList.add(book1);
        resultList.add(book2);

        assertEquals(bookList, resultList);
    }
}