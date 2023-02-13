package kolpakovee.generators;

import kolpakovee.models.Book;

import java.util.Random;

/**
 * Класс - генератор книги
 */
public class BookGenerator {
    /**
     * Список глаголов для генерации названия книги
     */
    private static final String[] verbs = new String[]{
            "Build", "Make", "Buy", "Do", "Read",
            "Write", "Open", "Close", "Teach", "Play",
            "Understand", "Decide", "Eat", "Hate",
            "Give", "Need", "Keep", "Create", "Choose"
    };

    /**
     * Список существительных для генерации названия книги
     */
    private static final String[] nouns = new String[]{
            "code", "book", "programmer", "teacher", "student",
            "project", "animal", "car", "face", "home", "horse",
            "king", "life", "phone", "problem", "question",
            "sound", "space", "world"
    };

    /**
     * Список наречий для генерации названия книги
     */
    private static final String[] adverbs = new String[]{
            "slowly", "fast", "quickly", "seldom",
            "once", "always", "often", "never",
            "quite", "everywhere", "outside"
    };

    /**
     * Метод - генерация новой книги
     * @return новую книгу
     */
    public static Book generate(){
        Random random = new Random();
        String name = verbs[random.nextInt(verbs.length)] + " " + nouns[random.nextInt(nouns.length)] + " " +
                adverbs[random.nextInt(adverbs.length)];
        return new Book(name, "", AuthorGenerator.generate(), random.nextInt(2024));
    }
}
