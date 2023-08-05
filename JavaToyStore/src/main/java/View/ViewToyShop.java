package View;

import Model.Toy;

import java.util.Scanner;

public class ViewToyShop {
    /***
     * Class with menu interactions and options
     */
    private Scanner scanner = new Scanner(System.in);


    public void View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("_______________________");
        System.out.println("Choose an option");
        System.out.println("1. Show prize pool");
        System.out.println("2. Try your luck");
        System.out.println("3. Add toy");
        System.out.println("4. Delete Toy");
        System.out.println("5. Update Toy Weight");
        System.out.println("6. exit");
    }

    public int getMenuChoice() {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }


}
