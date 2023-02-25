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
     * @return если название книги - null, то возвращаем список всех книг, иначе
     * список всех книг, содержащих название книги
     */
    public List<Book> getBooksByName(String nameOfBook) {
        if (nameOfBook == null) {
            return books;
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
    public Optional<Book> getBook(Book book) {
        if (book == null){
            return Optional.empty();
        }

        Optional<Book> optionalBook = books.stream()
                .filter(book1 -> book1.equals(book)).findFirst();

        if (optionalBook.isEmpty()){
            return optionalBook;
        }

        books.remove(optionalBook.get());

        return optionalBook;
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
