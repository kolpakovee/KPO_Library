package kolpakovee.models;

/**
 * Класс - автор книги
 * Каждый автор имеет имя и фамилию, а так же getter для доступа к этим полям
 */
public class Author {
    private final String name;
    private final String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
