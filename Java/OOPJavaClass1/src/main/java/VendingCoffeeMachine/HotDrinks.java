package VendingCoffeeMachine;

public class HotDrinks extends Product {

    int volume;
    ProductRange.HotDrinksRange type;

    public HotDrinks(String name, int price,int volume, ProductRange.HotDrinksRange type) throws Exception {
        super(name, price);
        this.type = type;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

//    public void setVolume(int volume) {
//        this.volume = volume;
//    }

    @Override
    public String toString() {
        return super.toString() + String.format(", volume: %s, type: %s", this.volume, this.type);
    }
}
