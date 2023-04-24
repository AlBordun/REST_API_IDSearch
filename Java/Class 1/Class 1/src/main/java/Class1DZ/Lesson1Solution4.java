package Class1DZ;

import java.util.Date;
import java.util.Scanner;

//В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
public class Lesson1Solution4 {
    public static void main(String args[]) {
        Scanner greetings = new Scanner(System.in);
        System.out.println("Input Name: ");
        String name = greetings.nextLine();
        var h = (new Date()).getHours();
        if (h > 6 && h < 12) System.out.printf("Доброе утро, %s!%n", name);
        if (h > 11 && h < 17) System.out.printf("Добрый день, %s!%n", name);
        if (h > 16 && h < 24) System.out.printf("Добрый вечер, %s!%n", name);
        if (h > 1 || h < 5) System.out.printf("Доброй ночи, %s!%n", name);

    }

}
