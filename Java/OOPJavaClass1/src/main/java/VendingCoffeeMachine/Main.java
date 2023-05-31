package VendingCoffeeMachine;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vm = new VendingMachine();
        vm.addProduct(new Snacks("Mars",98,100,ProductRange.SnacksRange.Mars));
        vm.addProduct(new Snacks("Twix", 85,120,ProductRange.SnacksRange.Twix));
        vm.addProduct(new Snacks("Bounty", 90,110,ProductRange.SnacksRange.Bounty));
        vm.addProduct(new Snacks("Snickers", 87,85,ProductRange.SnacksRange.Snickers));
        vm.addProduct(new HotDrinks("Latte", 120,250, ProductRange.HotDrinksRange.Latte ));
        vm.addProduct(new HotDrinks("Espresso", 100,250, ProductRange.HotDrinksRange.Espresso ));
        vm.addProduct(new HotDrinks("Latte", 120,250, ProductRange.HotDrinksRange.Latte ));
        vm.addProduct(new HotDrinks("GreenTea", 120,250, ProductRange.HotDrinksRange.GreenTea ));
        vm.addProduct(new HotDrinks("BlackTea", 120,250, ProductRange.HotDrinksRange.BlackTea ));
        vm.addProduct(new HotDrinks("HotChocolate", 120,250, ProductRange.HotDrinksRange.HotChocolate ));
        vm.addProduct(new HotDrinks("DoubleEspresso", 120,250, ProductRange.HotDrinksRange.DoubleEspresso ));
        vm.addProduct(new HotDrinks("Lungo", 120,250, ProductRange.HotDrinksRange.Lungo ));

        System.out.println(vm);

    }
}
