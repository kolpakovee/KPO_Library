package kolpakovee.controller;

import kolpakovee.view.ConsoleManager;
import kolpakovee.models.Book;
import kolpakovee.models.Library;
import kolpakovee.models.User;

import java.util.List;

/**
 * Класс для взаимодействия пользователя и библиотеки
 */
public class LibraryManager {
    /**
     * Получение книги по имени (не получилось сделать его совсем не связанным с консолью, но свзаность минимальная)
     * @param user пользователь, берущий книгу
     * @param library библиотека, в которой берут книгу
     * @param bookName название книги
     * @return true, если книга взята успешно
     */
    public static boolean getBookByName(User user, Library library, String bookName) {
        List<Book> books = library.getBooksByName(bookName);

        if (books.size() == 0) {
            return false;
        }

        if (books.size() == 1) {
            user.getBookFromLibrary(library, books.get(0));
            return true;
        }

        // единственный вызов, завязанный на консоли
        Book resultBook = ConsoleManager.chooseBookFromList(books);

        user.getBookFromLibrary(library, resultBook);

        return true;
    }

    /**
     * Метод для возврата книги в библиотеку (по названию),
     * (не получилось сделать его совсем не связанным с консолью, но свзаность минимальная)
     * @param user пользователь, возвращающий книгу
     * @param library бибилоитека, куда возвращают книгу
     * @param bookName название книги
     * @return true, если книгу получилось вернуть
     */
    public static boolean putBookByName(User user, Library library, String bookName) {
        List<Book> books = user.getBooksByName(bookName);

        if (books.size() == 0) {
            return false;
        }

        if (books.size() == 1) {
            user.returnBook(books.get(0), library);
            return true;
        }

        // единственный вызов, завязанный на консоли
        Book resultBook = ConsoleManager.chooseBookFromList(books);

        user.returnBook(resultBook, library);

        return true;
    }
}
