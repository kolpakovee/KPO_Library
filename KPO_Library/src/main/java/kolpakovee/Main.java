package kolpakovee;

import kolpakovee.generators.LibraryGenerator;
import kolpakovee.models.Author;
import kolpakovee.models.Book;
import kolpakovee.models.Library;
import kolpakovee.models.User;
import kolpakovee.utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // - Написать тесты
        User user = new User();
        Library library = LibraryGenerator.generate();
        ConsoleUtils.handle(user, library);
    }
}