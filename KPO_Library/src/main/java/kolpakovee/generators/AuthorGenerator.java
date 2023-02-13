package kolpakovee.generators;

import kolpakovee.models.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс - генератор авторов
 */
public class AuthorGenerator {
    /**
     * Массив имён для авторов
     */
    private static final String[] names = new String[]{
            "Egor", "Andrey", "Aleksandr", "Mikhail",
            "Aleksey", "Leonid", "Ilya", "Ivan"
    };

    /**
     * Массив фамилий авторов
     */
    private static final String[] surnames = new String[]{
            "Kolpakov", "Morin", "Afonin", "Davydov",
            "Ivashchenko", "Nedzelnicky", "Shilov"
    };

    /**
     * Метод для генерации автора списка авторов (от 1 до 3)
     * @return список новых авторов
     */
    public static List<Author> generate() {
        Random random = new Random();
        List<Author> result = new ArrayList<>();
        int count = random.nextInt(4);
        do {
            result.add(new Author(names[random.nextInt(names.length)],
                    surnames[random.nextInt(surnames.length)]));
            count--;
        } while (count > 0);

        return result;
    }

}
