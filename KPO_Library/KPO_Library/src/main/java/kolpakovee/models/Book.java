package kolpakovee.models;

import java.util.List;
import java.util.Objects;

/**
 * Класс - книга
 * Книга содержит название, описание, авторов и год публикации и getters для этих полей
 */
public class Book {
    /**
     * Название книги
     */
    private final String name;
    /**
     * Описание книги
     */
    private final String description;
    /**
     * Авторы книги
     */
    private final List<Author> authors;
    /**
     * Год публикации
     */
    private final int yearOfPublishing;

    public Book(String name, String description, List<Author> authors, int yearOfPublishing){
        this.name = name;
        this.description = description;
        this.authors = authors;
        this.yearOfPublishing = yearOfPublishing;
    }

    /**
     * Getter для названия книги
     * @return название книги
     */
    public String getName() {
        return name;
    }

    /**
     * Getter для описания книги
     * @return описание книги
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter для списка авторов книги
     * @return список авторов книги
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Getter для года публикации
     * @return год публикации книги
     */
    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearOfPublishing != book.yearOfPublishing) return false;
        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(description, book.description)) return false;
        return Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + yearOfPublishing;
        return result;
    }
}
