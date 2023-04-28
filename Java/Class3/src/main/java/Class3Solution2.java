//Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
// что на 0й позиции каждого внутреннего списка содержится название жанра,
// а на остальных позициях - названия книг.
//Напишите метод для заполнения данной структуры(можно через консоль).

import java.util.*;

public class Class3Solution2 {
    public static void main(String[] args) {
        List<ArrayList<String>> catalog = fillCatalog();
        printCatalog(catalog);
    }

    public static List<ArrayList<String>> fillCatalog() {
        List<ArrayList<String>> catalog = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название жанра или 'стоп' для завершения ввода:");
            String genreName = scanner.nextLine();
            if (genreName.equals("стоп")) {
                break;
            }

            ArrayList<String> genre = new ArrayList<>();
            genre.add(genreName);

            fillGenre(genre, scanner);

            catalog.add(genre);
        }

        return catalog;
    }

    public static void fillGenre(ArrayList<String> genre, Scanner scanner) {
        while (true) {
            System.out.println("Введите название книги или 'стоп' для завершения ввода жанра:");
            String bookName = scanner.nextLine();
            if (bookName.equals("стоп")) {
                break;
            }
            genre.add(bookName);
        }
    }

    public static void printCatalog(List<ArrayList<String>> catalog) {
        System.out.println("Каталог книг:");

        for (ArrayList<String> genre : catalog) {
            System.out.println("- " + genre.get(0) + ":");

            for (int i = 1; i < genre.size(); i++) {
                System.out.println("  - " + genre.get(i));
            }
        }
    }
}

