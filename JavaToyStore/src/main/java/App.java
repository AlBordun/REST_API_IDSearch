import Model.LottaryManager;
import Model.Toy;
import Model.ToyManager;
import View.ViewToyShop;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
        ViewToyShop menu = new ViewToyShop();
        LottaryManager lottaryManager = new LottaryManager();
        Scanner sc = new Scanner(System.in);
        Toy toy1 = new Toy(1, "smith", 5);
        Toy toy2 = new Toy(2, "smith1", 7);
        Toy toy3 = new Toy(3, "smith2", 11);
        Toy toy4 = new Toy(4, "smith3", 9);
//        Queue<Toy> t1 = new PriorityQueue<>();
        toyManager.addToyToStock(toy1);
        toyManager.addToyToStock(toy2);
        toyManager.addToyToStock(toy3);
        toyManager.addToyToStock(toy4);
        toyManager.getLotteryManager().addPrizeToy(toy1);
        toyManager.getLotteryManager().addPrizeToy(toy2);
        toyManager.getLotteryManager().addPrizeToy(toy3);
        toyManager.getLotteryManager().addPrizeToy(toy4);
        int choice = 0;
        while (choice != 6) {
            menu.showMenu();
            choice = menu.getMenuChoice();

            switch (choice) {
                case 1 -> {
                    toyManager.showStorage();
                }
                case 2 -> { // выполняем розыгрыш и выдачу игрушки
                    try {
                        FileWriter writer = new FileWriter("result.txt");

                        // Выполнение разыгрывания игрушек 10 раз
                        for (int i = 0; i < 10; i++) {
                            Toy prizeToy = toyManager.getLotteryManager().getRandomPrizeToy();
                            if (prizeToy != null) {
                                writer.write("Dropped: " + prizeToy.getId() + prizeToy.getName() + "\n");
                            }
                            else {
                                writer.write("Can't find a toy\n");
                            }
                        }
                        writer.close();
                        System.out.println("Results saved in 'result.txt'.");
                    } catch (IOException e) {
                        System.out.println("Error occurred while writing to the file.");
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    // добавляем игрушки в розыгрыш
                    while (true) {
                        System.out.print("Write toy id (or exit to finish): ");
                        String idInput = sc.nextLine();
                        int newId = Integer.parseInt(idInput);
                        if (idInput.equalsIgnoreCase("exit")) {
                            break;
                        }
                        System.out.print("Write toy name: ");
                        String nameInput = sc.nextLine();

                        System.out.print("Write toy Weight: ");
                        int selectionWeightInput = sc.nextInt();

                        Toy customtoy = new Toy(newId, nameInput, selectionWeightInput);
                        toyManager.addToyToStock(customtoy);
                        toyManager.getLotteryManager().addPrizeToy(customtoy);
                        // Вывод элементов очереди
//                        System.out.println("Toys in queue:");
//                        while (!toyManager.getLotteryQueue().isEmpty()) {
//                            System.out.println(toyManager.getLotteryQueue());
//                        }
                        break;
                    }
                }
                case 4 -> {
//                    int input = 0;
//                    System.out.println("write an id to delete");
//                    input = sc.nextInt();
//                    for (Toy toy : toyManager.getLotteryQueue()
//                    ) {
//                        toyManager.removeToyFromStock(input);
//                    }
//                    System.out.println("Updated queue: " + toyManager.getLotteryQueue());
                    System.out.print("Write an id for a toy to delete: ");
                    int id = sc.nextInt();

                    toyManager.removeToyById(toyManager.getLotteryQueue(), id);

                    System.out.println("Updated queue:");
                    for (Toy toy : toyManager.getLotteryQueue()) {
                        System.out.println(toy.getId() + " " + toy.getName());
                    }
                }

                case 5 -> { //update the toy weight
                    System.out.println("write an id to update");
                    toyManager.getLotteryQueue();
                    int toyIdFromUser = sc.nextInt();
                    System.out.println("write new weight for a toy");
                    int toyWeigth = sc.nextInt();
                    if (toyWeigth != 0) {
                        toyManager.getExistingToyFromStorage(toyIdFromUser).setSelectionWeight(toyWeigth);
                    } else {
                        System.out.println("Wrong input, try again...");
                    }
//                    for (Toy toy : toyManager.getStorageStock()) {
//                        if (toy != null || toyWeigth != 0) {
//                            toy.setSelectionWeight(input);
//                        }
//                        toyManager.updateToyWeight(toy);
//                    }
                    System.out.println("Updated queue: " + toyManager.getLotteryQueue());
                }
                case 6 -> {
                    System.out.println("Exit");
                    break;
                }
//                default:
//                    System.out.println("Invalid choice");
            }

        }
    }
}


