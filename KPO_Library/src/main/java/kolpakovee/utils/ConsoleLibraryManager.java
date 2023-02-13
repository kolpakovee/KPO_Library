package kolpakovee.utils;

import kolpakovee.models.Book;
import kolpakovee.models.Library;
import kolpakovee.models.User;

import java.util.List;

/**
 * Класс для работы с бибилиотекой, используя консоль
 * Реализует интерфейс LibraryManager
 */
public class ConsoleLibraryManager implements LibraryManager {
    /**
     * Метод для получения пользователем книги из библиотеки
     * @param user пользователь
     * @param library бибилиотека
     * @param bookName название книги
     */
    @Override
    public void getBookByName(User user, Library library, String bookName) {
        List<Book> books = library.getBooksByName(bookName);

        if (books == null || books.size() == 0) {
            System.out.println("\nВ БИБЛИОТЕКЕ НЕТ ТАКОЙ КНИГИ НА ДАННЫЙ МОМЕНТ...");
            return;
        }

        if (books.size() == 1) {
            user.getBookFromLibrary(library, books.get(0));
            System.out.println("\nКНИГА ВЗЯТА УСПЕШНО!");
            return;
        }

        ConsoleUtils.writeBooks(books);

        System.out.print("\nВЫБЕРИТЕ КНИГУ ИЗ СПИСКА (ВВЕДИТЕ ЕЁ НОМЕР В СПИСКЕ): ");

        int index = ConsoleUtils.getBookNumber(books);

        if (index == -1){
            return;
        }

        user.getBookFromLibrary(library, books.get(index - 1));

        System.out.println("\nКНИГА ВЗЯТА УСПЕШНО!");
    }

    /**
     * Метод для возвращения книги в бибилиотеку
     * @param user пользователь, который хочет вернуть книгу
     * @param library библиотека
     * @param bookName название возвращаемой книги
     */
    @Override
    public void putBook(User user, Library library, String bookName) {
        List<Book> books = user.getBooksByName(bookName);

        if (books == null || books.size() == 0) {
            System.out.println("\nУ ПОЛЬЗОВАТЕЛЯ НЕТ КНИГ С ТАКИМ НАЗВАНИЕМ...");
            return;
        }

        if (books.size() == 1) {
            user.returnBook(books.get(0), library);
            System.out.println("\nКНИГА ВОЗВРАЩЕНА УСПЕШНО!");
            return;
        }

        System.out.println("\nКАКУЮ КНИГУ ВЫ ХОТИТЕ ВЕРНУТЬ?");

        ConsoleUtils.writeBooks(books);

        int index = ConsoleUtils.getBookNumber(books);

        if (index == -1){
            return;
        }

        user.returnBook(books.get(index - 1), library);

        System.out.println("\nКНИГА ВОЗВРАЩЕНА УСПЕШНО!");
    }

    /**
     * Метод для получения и вывода в консоль всех книг в библиотеке
     * @param library библиотека, список книг которой хотим получить
     */
    @Override
    public void allBooks(Library library) {
        List<Book> books = library.getBooks();

        if (books == null || books.size() == 0) {
            System.out.println("\nВ БИБЛИОТЕКЕ НЕТ КНИГ НА ДАННЫЙ МОМЕНТ...");
            return;
        }

        System.out.println("\nВСЕ КНИГИ В БИБЛИОТЕКЕ:");
        ConsoleUtils.writeBooks(books);
    }

    /**
     * Метод для получения и вывода в консоль всех книг пользователя
     * @param user пользователь, список кинг которого хотим получить
     */
    @Override
    public void usersBook(User user) {
        List<Book> books = user.getBooks();

        if (books == null || books.size() == 0) {
            System.out.println("\nУ ПОЛЬЗОВАТЕЛЯ НЕТ КНИГ НА ДАННЫЙ МОМЕНТ...");
            return;
        }

        System.out.println("\nВСЕ КНИГИ ПОЛЬЗОВАТЕЛЯ:");
        ConsoleUtils.writeBooks(user.getBooks());
    }
}
