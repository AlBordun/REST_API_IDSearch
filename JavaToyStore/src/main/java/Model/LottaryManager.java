package Model;

import Model.Toy;


import java.util.PriorityQueue;
import java.util.Random;

public class LottaryManager {

    private PriorityQueue<Toy> prizeToys;

    public LottaryManager() {
        prizeToys = new PriorityQueue<>
                ((t1, t2) -> Double.compare(t2.getSelectionWeight(), t1.getSelectionWeight()));
    }

    public void addPrizeToy(Toy toy) {
        prizeToys.add(toy);
    }

    public Toy getRandomPrizeToy() {
        if (prizeToys.isEmpty()) {
            return null; // Return null if no toys are available for the lottery
        }
        int totalWeight = 0;
        for (Toy toy : prizeToys) {
            totalWeight += toy.getSelectionWeight();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight) + 1; // Генерируем случайное число от 1 до суммарного веса игрушек

        int currentWeight = 0;
        for (Toy toy : prizeToys) {
            currentWeight += toy.getSelectionWeight();
            if (randomNumber <= currentWeight) {
                return toy; // Возвращаем игрушку
            }
        }

        return null; // Возвращаем null, если ни одна игрушка не выпала
    }

}

