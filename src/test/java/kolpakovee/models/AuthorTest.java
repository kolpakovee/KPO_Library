package kolpakovee.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    @Test
    @DisplayName("Проверяем, что авторы с одинаковыми именами и фамилиями - разные люди, если это разные объекты")
    void not_equals_authors_with_same_fields_test_expected_false() {
        Author author1 = new Author("Egor", "Kolpakov");
        Author author2 = new Author("Egor", "Kolpakov");

        assertNotEquals(author1, author2);
    }

    @Test
    @DisplayName("Проверяем, что авторы с разными именами и фамилиями - разные люди")
    void not_equals_authors_with_different_fields_test_expected_false() {
        Author author1 = new Author("Egor", "Kolpakov");
        Author author2 = new Author("Max", "Kolpakov");

        assertNotEquals(author1, author2);
    }
}