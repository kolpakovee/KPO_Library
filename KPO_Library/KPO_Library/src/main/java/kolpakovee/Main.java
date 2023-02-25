package kolpakovee;

import kolpakovee.generators.LibraryGenerator;
import kolpakovee.view.ConsoleApplication;
import kolpakovee.models.Library;
import kolpakovee.models.User;

public class Main {
    public static void main(String[] args) {
        // - Написать тесты
        User user = new User();
        Library library = LibraryGenerator.generate();
        ConsoleApplication.start(user, library);
    }
}