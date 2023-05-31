package VendingCoffeeMachine;

public class Snacks extends Product {

    private int weightGrams;
    ProductRange.SnacksRange type;
    public Snacks(String name, int price,int weightGrams, ProductRange.SnacksRange type ) throws Exception {
        super(name, price);
        this.type = type;
        this.weightGrams = weightGrams;
    }

    public int getWeightGrams(){
        return weightGrams;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", weightGrams: %s, type: %s", this.weightGrams, this.type);
    }

}
