package Model;


import java.util.*;

public class ToyManager {
    private PriorityQueue<Toy> lotteryQueue;

//    private ArrayList<Toy> storageStock;

    private LottaryManager lottaryManager;


    public ToyManager() {
        lotteryQueue = new PriorityQueue<>();
//        ((t1, t2) -> t2.getSelectionWeight() - t1.getSelectionWeight());
        lottaryManager = new LottaryManager();
    }

    public PriorityQueue<Toy> getLotteryQueue() {
        return lotteryQueue;
    }

//    public PriorityQueue<Toy> getStorageStock() {
//        return lotteryQueue;
//    }

    public LottaryManager getLotteryManager() {
        return lottaryManager;
    }

//    public void setStorageStock(ArrayList<Toy> storageStock) {
//        this.storageStock = storageStock;
//    }

    public void addToyToStock(Toy toy) {
        lotteryQueue.add(toy);
    }

    //    public void removeToyFromStock(Toy toy) {
//        if (toy != null) {
//           boolean removed = lotteryQueue.remove(toy.getId());
//        }
//    }
    public void removeToyById(PriorityQueue<Toy> lotteryQueue, int id) {
        Iterator<Toy> iterator = lotteryQueue.iterator();
        while (iterator.hasNext()) {
            Toy toy = iterator.next();
            if (toy.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void showStorage() {
        for (Toy toy : this.lotteryQueue
        ) {
            System.out.println(toy);
        }
    }


//    public void updateToyWeight(Toy toy) {
//        if (toy != null) {
//            storageStock.;
//        }
//    }

    public Toy getExistingToyFromStorage(int toyId) {
        Optional<Toy> toyOptional = this.lotteryQueue.stream()
                .filter(toy -> Objects.equals(toy.getId(), toyId))
                .findFirst();
        return toyOptional.orElse(null); // Return null if the Toy with the given toyId is not found
    }
//    public Toy getRandomToy() {
//        Random random = new Random();
//        int totalWeight = lotteryQueue.stream().mapToInt(Toy::getSelectionWeight).sum();
//        int randomWeight = random.nextInt(totalWeight) + 1;
//        int cumulativeWeight = 0;
//
//        for (Toy toy : lotteryQueue) {
//            cumulativeWeight += toy.getSelectionWeight();
//            if (randomWeight <= cumulativeWeight) {
//                return toy;
//            }
//        }
//        return null;
//    }

}
