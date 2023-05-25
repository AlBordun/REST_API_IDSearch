package Class6;

import java.util.*;

public class Laptop {

    private String name;
    private int amountRAM;
    private String OS;
    private int price;
    private String model;

    public Laptop(String name, int amountRAM, String operatingSystem, int price, String model) {
        this.name = name;
        this.amountRAM = amountRAM;
        this.OS = operatingSystem;
        this.price = price;
        this.model = model;
    }



    @Override
    public String toString() {
        return "Ноутбук: (" + name + "): " +
                "количество опретивной памяти:" + amountRAM +
                ", операционная система: " + OS + '\'' +
                ", цена: " + price +
                ", модель: " + model;
    }

    public String getName() {

        return name;
    }

    public int getAmountRAM() {

        return amountRAM;
    }

    public String getOS() {
        return OS;
    }
    public int getPrice() {

        return price;
    }

    public String getModel() {

        return model;
    }

}
