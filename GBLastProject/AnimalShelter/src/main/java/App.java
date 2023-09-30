import Controller.ShelterController;
import Model.Animal;
import Model.Commands;
import View.Menu;

import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Animal> animals = new ArrayList<>();
        Animal animal = new Animal("Boy",1, "2023-09-29", "Sit,Lay down", "Dog");
        Animal animal1 = new Animal("Boi", animal.getId(), "2023-09-29", "Sit,Bark", "Hamster");
        Animal animal2 = new Animal("ExtraBoi", animal.getId(), "2023-09-29", "Follow,Lay down", "Cat");
        animals.add(animal);
        animals.add(animal1);
        animals.add(animal2);

        ShelterController shelterController = new ShelterController();
        Menu menu = new Menu();
        int choice = 0;
        while (choice != 7) {
            menu.showMenu();
            choice = menu.getMenuChoice();

            switch (choice) {
                case 1 -> {
                    shelterController.createAnimal(animals, scanner);
                }
                case 2 -> {
                    int id = scanner.nextInt();
                    shelterController.editAnimal(animals, id, scanner);
                }
                case 3 -> {
                    shelterController.showCommands(animals, scanner);
                }
                case 4 -> {
                    shelterController.addNewCommand(animals, scanner);
                }
                case 5 -> {
                    shelterController.listOfAnimal(animals);
                }
                case 6 -> {
                    int id = scanner.nextInt();
                    shelterController.deleteAnimal(animals, id);
                }
                case 7 -> {
                    System.out.println("Exit");
                    break;
                }
            }
        }
    }
}

