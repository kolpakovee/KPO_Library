package kolpakovee.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс пользователя
 * У каждого пользователя есть список книг, он может
 * пополнять его, взяв книгу в бибилиотеке, и возвращать книги обратно
 */
public class User {
    /**
     * Список книг пользователя
     */
    private final List<Book> books;

    public User() {
        books = new ArrayList<>();
    }

    /**
     * Метод для возврата книги в бибилиотеку
     * @param book книга, которую пользователь хочет вернуть
     * @param library библиотека, в которую возвращаем книгу
     */
    public void returnBook(Book book, Library library) {
        if (book == null || !books.contains(book)) {
            return;
        }
        library.putBook(book);
        books.remove(book);

    }

    /**
     * Метод для взятия книги из библиотеки
     * @param library библиотека, из которой пользователь собирается взять книгу
     * @param book книга, которую пользователь хочет взять
     */
    public void getBookFromLibrary(Library library, Book book) {
        Book newBook = library.getBook(book);

        if (newBook == null) {
            return;
        }

        books.add(newBook);
    }

    /**
     * Метод, чтобы получить все книги пользователя по заданному названию
     * @param bookName название книги
     * @return список книг, которые содержат название
     */
    public List<Book> getBooksByName(String bookName) {
        if (bookName == null) {
            return null;
        }

        return books.stream()
                .filter(book -> book.getName().contains(bookName))
                .collect(Collectors.toList());
    }

    /**
     * Гетер для доступа к списку всех книг пользователя
     * @return список книг пользователя
     */
    public List<Book> getBooks() {
        return books;
    }
}
