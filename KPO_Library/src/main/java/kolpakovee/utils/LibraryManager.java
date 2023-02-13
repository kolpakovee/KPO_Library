package kolpakovee.utils;

import kolpakovee.models.Library;
import kolpakovee.models.User;

/**
 * Интерфейс для взаимодействия между пользователем и библиотекой
 * Идея в том, чтобы при добавлении нового способа получения информации
 * Например, не из консоли, а из чата в телеграме, реализовать этот интерфейс и не переписывать остальной бэк
 */
public interface LibraryManager {
    /**
     * Метод для получения книги из библиотеки пользователем
     * @param user пользователь, который берёт книгу
     * @param library библиотека, из которой берут книгу
     * @param bookName название книги
     */
    void getBookByName(User user, Library library, String bookName);

    /**
     * Метод для возврата книги в библиотеку пользователем
     * @param user пользователь, который возвращает книгу
     * @param library библиотека, в которую возвращают книгу
     * @param bookName название книги
     */
    void putBook(User user, Library library, String bookName);

    /**
     * Метод для получения списка всех книг из библиотеки и вывода этого
     * списка куда-либо
     * @param library библиотека, список книг которой хотим получить
     */
    void allBooks(Library library);

    /**
     * Метод для получения всех книг пользователя и вывода его куда-либо
     * @param user пользователь, книги которого хотим получить
     */
    void usersBook(User user);
}
