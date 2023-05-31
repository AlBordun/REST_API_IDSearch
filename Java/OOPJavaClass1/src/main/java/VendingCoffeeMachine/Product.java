package VendingCoffeeMachine;

public class Product {
    private int price;
    private final String name;

    public Product(String name, int price) throws Exception{
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

//    public void setPrice(double price) {
//        if (price <= 0) {
//            throw new IllegalStateException(String.format("Цена указана некорректно!", price));
//        }
//        this.price = price;
//    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
       return String.format("name: %s, price: %s", this.name, this.price);
    }
}
