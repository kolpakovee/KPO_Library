package kolpakovee.view;

import kolpakovee.models.Library;
import kolpakovee.models.User;

/**
 * Класс для функционирования консольно приложения
 */
public class ConsoleApplication {
    /**
     * Метод для запуска консольного приложения
     * @param user    пользователь, команды от которого получаем
     * @param library библиотека для взаимодействия с ней
     */
    public static void start(User user, Library library) {
        ConsoleCommandHandler.handle(user, library);
    }
}
