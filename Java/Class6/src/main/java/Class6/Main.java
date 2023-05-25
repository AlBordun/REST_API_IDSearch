package Class6;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Laptop> set = new HashSet<>();
        set.add(new Laptop("Notebook 1", 8, "Windows10", 80000, "HP"));
        set.add(new Laptop("Notebook 2", 16, "Windows10", 85000, "Asus"));
        set.add(new Laptop("Notebook 3", 32, "linux", 85000, "Lenovo"));
        set.add(new Laptop("Notebook 4", 64, "linux", 90000, "Lenovo"));

        Filter filter = new Filter(set);
        filter.start();


    }
}
