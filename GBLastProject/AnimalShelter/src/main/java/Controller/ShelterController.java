package Controller;

import DAO.AnimalDAO;
import DAO.CommandsDAO;
import Model.Animal;
import Model.Commands;
import Model.PackAnimal;
import Model.PetAnimal;
import Services.AnimalService;
import DAO.AnimalDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShelterController {

    private List<Animal> animals = new ArrayList<>();
    private AnimalService animalsService;

//    public void addAnimalToShelter(Animal animal) {
//        animals.add(animal);
//    }


    public void createAnimal(List<Animal> animals, Scanner scanner) {
        System.out.println("Pack or Pet");
        String classofAnimal = scanner.nextLine();
        System.out.println("Введите id животного:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите дату в формате yyyy-MM-dd:");
        String dateString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = format.parse(dateString);
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Введите команды животного:");
        String newCommand = scanner.nextLine();

        Animal animal = new Animal(name, id,dateString, newCommand, classofAnimal);
        animals.add(animal);

        System.out.println("Животное успешно добавлено в список.");

        System.out.println("Содержимое списка:");
        for (
                Animal a : animals) {
            System.out.println(a.getId() + " " + a.getName() + " " + a.getDateOfBirth() + " " + a.getClassOfAnimal());
        }

    }


    public void listOfAnimal(List<Animal> animalList) {
        System.out.println("Список всех животных:");

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }


    public void deleteAnimal(List<Animal> animalList, int id) {
        Animal animalToRemove = null;
        for (Animal animal : animalList) {
            if (Objects.equals(animal.getId(), id)) {
                animalToRemove = animal;
                break;
            }
        }
        if (animalToRemove != null) {
            animalList.remove(animalToRemove);
        }
    }

    public void editAnimal(List<Animal> animals, int id, Scanner scanner) {
        System.out.print("Введите id животного для редактирования: ");
        Animal animalToEdit = null;
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), id)) {
                animalToEdit = animal;
                break;
            }
        }
        if (animalToEdit != null) {
            System.out.print("Введите новое название животного: ");
            String newName = scanner.next();

            animalToEdit.setName(newName);

            System.out.println("Животное успешно отредактировано.");
        } else {
            System.out.println("Животное с указанным id не найдено.");
        }
    }


    public void editCommands(List<Animal> animals, Scanner scanner) {
        System.out.println("Введите название команды для редактирования:");
        String input = scanner.nextLine();

        for (Animal animal : animals) {
            if (String.valueOf(animal.getCommands()).equals(input)) {


                if (animals != null) {
                    System.out.println("Команда найдена. Введите новую команду:");
                    String newCommand = scanner.nextLine();

                    // Обновление команды животного
                    animal.setCommands(newCommand);

                    System.out.println("Команда успешно изменена.");
                } else {
                    System.out.println("Команда не найдена.");
                }
            }
        }
    }

    public static void updateCommand(Animal animal, String newCommand) {
        animal.setCommands(newCommand);
    }

    public void addNewCommand(List<Animal> animals, Scanner scanner) {
        System.out.println("Введите ID животного: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное id.");
            scanner.next();
        }
        int animalId = scanner.nextInt();

        Animal animal = findAnimalById(animals, animalId);

        System.out.print("Введите новую команду: ");
        String newCommand = scanner.next();

        if (animal != null) {
            updateCommand(animal, newCommand);
            System.out.println("Команда для животного успешно обновлена.");
        } else {
            System.out.println("Животное не найдено.");
        }

    }

    public void showCommands(List<Animal> animals, Scanner scanner) {
        System.out.println("Введите ID животного: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное id.");
            scanner.next();
        }
        int animalId = scanner.nextInt();

        // Находим животное по ID
        Animal animal = findAnimalById(animals, animalId);

        if (animal != null) {
            System.out.println("Животное найдено.");
            List<String> commands = Collections.singletonList(animal.getCommands());
            System.out.println(commands);
        } else {
            System.out.println("Животное не найдено.");
        }

    }

    private Animal findAnimalById(List<Animal> animals, int animalId) {
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), animalId)) {
                return animal;
            }
        }
        return null; // Животное не найдено
    }
}
