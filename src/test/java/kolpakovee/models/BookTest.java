package kolpakovee.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    @DisplayName("Проверяем равны ли книги с одинаковыми полями")
    void equals_book_test_expected_true() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book1 = new Book("Как выжить на курсе по Java, если начал программировать на первом курсе",
                "Это книга о главном", authors, 2023);
        Book book2 = new Book("Как выжить на курсе по Java, если начал программировать на первом курсе",
                "Это книга о главном", authors, 2023);

        assertEquals(book1, book2);
    }

    @Test
    @DisplayName("Проверяем не равны ли книги с разными полями")
    void not_equals_book_test_expected_false() {
        List<Author> authors = new ArrayList<>();

        authors.add(new Author("Egor", "Kolpakov"));
        authors.add(new Author("Aleksandr", "Kuchuk"));

        Book book1 = new Book("Как выжить на курсе по Java, если начал программировать на первом курсе",
                "Это книга о главном", authors, 2023);
        Book book2 = new Book("Как чиллить на курсе по Java, если начал программировать в ноль лет",
                "Это книга о главном", authors, 1990);

        assertNotEquals(book1, book2);
    }



}