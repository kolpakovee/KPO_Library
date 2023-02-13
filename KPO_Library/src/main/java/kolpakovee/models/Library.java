package kolpakovee.models;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс - библиотека с книгами
 * Содержит список книг и методы для обращения с этим списокм
 */
public class Library {
    /**
     * Список книг, хранящихся в бибилиотеке
     */
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    /**
     * Getter для доступа к списку кинг
     * @return список книг в библиотеке
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Метод для получения книги из библиотеки по названию
     * @param nameOfBook название книги
     * @return если название книги - null, то возвращаем null, иначе
     * список всех книг, содержащих название книги
     */
    public List<Book> getBooksByName(String nameOfBook) {
        if (nameOfBook == null) {
            return null;
        }

        return books.stream()
                .filter(book -> book.getName().contains(nameOfBook))
                .collect(Collectors.toList());
    }

    /**
     * Метод для получения конкретной книги из библиотеки
     * @param book книга, которую пользователь хочет получить
     * @return если книги нет в библиотеке - null, иначе книгу
     */
    public Book getBook(Book book) {
        Optional<Book> optionalBook = books.stream()
                .filter(book1 -> book1.equals(book)).findFirst();

        if (optionalBook.isEmpty()){
            return null;
        }

        books.remove(optionalBook.get());

        return optionalBook.get();
    }

    /**
     * Метод для возврата книги в библиотеку
     * @param book - книга, которую хотят вернуть
     */
    public void putBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }
}
