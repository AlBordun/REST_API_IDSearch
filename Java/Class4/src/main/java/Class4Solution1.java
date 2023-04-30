//Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.

import java.util.*;

public class Class4Solution1 {
    public static void main(String[] args) {
        inputReader();
    }


    public static void printStringsInReverseOrder(List<String> listOfInputs) {
        for (int i = listOfInputs.size() - 1; i >= 0; i--) {
            System.out.println(listOfInputs.get(i));
        }
    }
    public static void removeLastStringFromMemory(List<String> listOfInputs) {
        if (!listOfInputs.isEmpty()) {
            listOfInputs.remove(listOfInputs.size() - 1);
            System.out.println(listOfInputs);
        }
    }

    public static void inputReader() {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfInputs= new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("print")) {
                printStringsInReverseOrder(listOfInputs);
            } else if (input.equals("revert")) {
                removeLastStringFromMemory(listOfInputs);
            } else {
                listOfInputs.add(input);
            }
        }
    }
}


