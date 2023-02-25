package kolpakovee.view;

import kolpakovee.models.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Класс для вывода в консоль / получения инфо от пользователя
 */
public class ConsoleManager {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Метод для получения от пользователя информации, какую книгу от хочет взять из списка
     * @param books список книг
     * @return книгу, которую хочет взять пользователь
     */
    public static Book chooseBookFromList(List<Book> books) {
        writeBooksToConsole(books);

        int index = -1;

        while (index < 1 || index > books.size()) {
            System.out.print("\nВЫБЕРИТЕ НОМЕР КНИГИ В СПИСКЕ: ");
            if (scanner.hasNextInt()){
                index = scanner.nextInt();
            } else {
                System.out.println("\nВВЕДЁННОЕ ЗНАЧЕНИЕ НЕКОРРЕКТНО!");
                scanner.next();
            }
        }

        return books.get(index - 1);
    }

    /**
     * Метод для выода списка книг в консоль
     *
     * @param books список книг
     */
    public static void writeBooksToConsole(List<Book> books) {
        if (books.size() == 0){
            System.out.println("\nУПС, КАЖЕТСЯ, ЗДЕСЬ ПУСТО...");
            return;
        }

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
     * Метод для реакции на команду /help от пользователя
     */
    public static void writeCommandsToConsole() {
        System.out.println("\nВОЗМОЖНЫЕ КОМАНДЫ:\n" +
                "/get <имя книги> - команда для получения книги по имени из библиотеки\n" +
                "/list - показывает, какие книги взял пользователь\n" +
                "/put <имя книги> - возвращает книгу в библиотеку\n" +
                "/all - список всех книг в библиотеке\n" +
                "/help - список команд\n" +
                "/quit - завершить выполнение программы");
    }
}
