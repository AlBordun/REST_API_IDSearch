import Exceptions.UserDataException;
import Model.FileWork;
import Model.User;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileWork fileWork = new FileWork(scanner);
//        FileWork fileWriter = new FileWork();

        try {
            User userData = fileWork.readUserData();
            fileWork.writeUserData(userData);
        } catch (UserDataException | IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

