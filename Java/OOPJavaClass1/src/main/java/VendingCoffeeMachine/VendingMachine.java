package VendingCoffeeMachine;
import java.util.*;
public class VendingMachine {

    private List<Product> productlist = new ArrayList<>();

    public List<Product> getProductList (Product product){
        return productlist;
    }

public void addProduct(Product product){
        this.productlist.add(product);
}
public Product getProductByName (String name) {
    for (Product product : productlist) {
        if (product.getName().equals(name)) {
            return product;
        }
    }
    return null;
}
    @Override
    public String toString() {
        String text = "";
        for (Product product : productlist){
            text += product.toString() + "\n";
        }
        return text;
    }
}