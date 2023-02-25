package kolpakovee.controller;

import kolpakovee.models.Command;
import kolpakovee.models.Library;
import kolpakovee.models.User;

/**
 * Класс для обработки команд, содержит один метод
 */
public class CommandHandler {
    /**
     * Метод для обработки команд (нет никакой реакции на ALL и LIST, потому что я не хотел
     * связывать этот класс с консолью, эти команды обрабатываются в ConsoleCommandHandler
     * @param command команда
     * @param library бибилиотека, с которой происходит взаимодейтвие
     * @param user пользователь, который береёт / возвращает книгу
     * @param bookName навазние книги (нужен для GET / PUT)
     * @return true - если пользователь успешно взял / вернул книгу
     */
    public static boolean handle(Command command, Library library, User user, String bookName) {
        switch (command) {
            case GET:
                return LibraryManager.getBookByName(user, library, bookName);
            case PUT:
                return LibraryManager.putBookByName(user, library, bookName);
            case ALL:
            case LIST:
                return true;
        }
        return true;
    }
}
