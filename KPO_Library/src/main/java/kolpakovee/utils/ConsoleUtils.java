package kolpakovee.utils;

import kolpakovee.models.Book;
import kolpakovee.models.Commands;
import kolpakovee.models.Library;
import kolpakovee.models.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс для взаимодейтсвия с пользователем через консоль
 * Содержит лишь статические методы
 */
public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Метод для выода списка книг в консоль
     * @param books список книг
     */
    public static void writeBooks(List<Book> books) {
        int index = 1;
        for (var book : books) {
            System.out.print("\n" + index++ + ") " + book.getName());
            for (var author : book.getAuthors()) {
                System.out.print(" | " + author.getName() + " " + author.getSurname());
            }
        }
        System.out.println();
    }

    /**
     * Метод для обработки команд пользователя
     * @param user пользователь, команды от которого получаем
     * @param library библиотека для взаимодействия с ней
     */
    public static void handle(User user, Library library) {
        ConsoleLibraryManager clm = new ConsoleLibraryManager();
        Commands command;

        System.out.println(getCommands());

        do {
            System.out.print("\nВВЕДИТЕ КОМАНДУ: ");
            String inputCommand = scanner.next();
            String bookName = null;

            if (Objects.equals(inputCommand, "/get") || Objects.equals(inputCommand, "/put")){
                bookName = scanner.nextLine().trim();
            }

            switch (inputCommand) {
                case "/get":
                    command = Commands.GET;
                    clm.getBookByName(user, library, bookName);
                    break;
                case "/put":
                    command = Commands.PUT;
                    clm.putBook(user, library, bookName);
                    break;
                case "/all":
                    command = Commands.ALL;
                    clm.allBooks(library);
                    break;
                case "/list":
                    command = Commands.LIST;
                    clm.usersBook(user);
                    break;
                case "/quit":
                    command = Commands.QUIT;
                    break;
                case "/help":
                    command = Commands.HELP;
                    System.out.println(getCommands());
                default:
                    command = Commands.DEFAULT;
                    break;
            }
        } while (command != Commands.QUIT);
    }

    /**
     * Метод для реакции на команду /help от пользователя
     * @return список доступных команд
     */
    public static String getCommands() {
        return "\nВОЗМОЖНЫЕ КОМАНДЫ:\n" +
                "/get <имя книги> - команда для получения книги по имени из библиотеки\n" +
                "/list - показывает, какие книги взял пользователь\n" +
                "/put <имя книги> - возвращает книгу в библиотеку\n" +
                "/all - список всех книг в библиотеке\n" +
                "/help - список команд\n" +
                "/quit - завершить выполнение программы";
    }

    /**
     * Метод для получения книги по номеру
     * Используется в ситуациях, когда несколько книг используют одинаковое название
     * @param books список книг, из которого выбираем
     * @return индекс выбранной книги
     */
    public static int getBookNumber(List<Book> books){
        int index;

        try {
            index = scanner.nextInt();
        } catch (InputMismatchException mismatchException) {
            System.out.println("\nВВЕДЁННОЕ ЗНАЧЕНИЕ НЕКОРРЕКТНО!");
            return -1;
        }

        if (index > books.size()){
            System.out.println("\nВВЕДЁННОЕ ЗНАЧЕНИЕ НЕКОРРЕКТНО!");
            return -1;
        }

        return index;
    }
}
