package kolpakovee.view;

import kolpakovee.controller.CommandHandler;
import kolpakovee.models.Command;
import kolpakovee.models.Library;
import kolpakovee.models.User;

import java.util.Scanner;

/**
 * Класс для обработки команд от пользователя (из консоли)
 */
public class ConsoleCommandHandler {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Единственный метод для обработки команд
     *
     * @param user    пользователь, который взаимодействует с библиотекой
     * @param library библиотека
     */
    public static void handle(User user, Library library) {
        String inputCommand;
        ConsoleManager.writeCommandsToConsole();
        do {
            System.out.print("\nВВЕДИТЕ КОМАНДУ: ");
            inputCommand = scanner.next();
            String bookName;

            switch (inputCommand) {
                case "/get":
                    bookName = scanner.nextLine().trim();
                    if (CommandHandler.handle(Command.GET, library, user, bookName)) {
                        System.out.println("\nКНИГА УСПЕШНО ВЗЯТА!");
                    } else {
                        System.out.println("\nНЕ УДАЛОСЬ ВЗЯТЬ КНИГУ!");
                    }
                    break;
                case "/put":
                    bookName = scanner.nextLine().trim();
                    if (CommandHandler.handle(Command.PUT, library, user, bookName)) {
                        System.out.println("\nКНИГА УСПЕШНО ВОЗВРАЩЕНА!");
                    } else {
                        System.out.println("\nНЕ УДАЛОСЬ ВЕРНУТЬ КНИГУ!");
                    }
                    break;
                case "/all":
                    ConsoleManager.writeBooksToConsole(library.getBooks());
                    break;
                case "/list":
                    ConsoleManager.writeBooksToConsole(user.getBooks());
                    break;
                case "/help":
                    ConsoleManager.writeCommandsToConsole();
                default:
                    break;
            }
        } while (!inputCommand.equals("/quit"));
    }
}
