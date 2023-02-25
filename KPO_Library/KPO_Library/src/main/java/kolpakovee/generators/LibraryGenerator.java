package kolpakovee.generators;

import kolpakovee.models.Book;
import kolpakovee.models.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс - генерация библиотеки
 */
public class LibraryGenerator {
    /**
     * Метод для генерации библиотеки
     * @return новую библиотеку
     */
    public static Library generate() {
        List<Book> books = new ArrayList<>();

        Random random = new Random();
        int count = random.nextInt(16);

        do {
            books.add(BookGenerator.generate());
            count--;
        } while (count > 0);

        return new Library(books);
    }
}
