package View;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);


    public void View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("_______________________");
        System.out.println("Choose an option");
        System.out.println("1. Add new animal");
        System.out.println("2. Edit animal");
        System.out.println("3. Show commands of the animal");
        System.out.println("4. Learn an animal new command");
        System.out.println("5. List of animals");
        System.out.println("6. Delete animal");
        System.out.println("7. exit");
    }

    public int getMenuChoice() {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }

}
