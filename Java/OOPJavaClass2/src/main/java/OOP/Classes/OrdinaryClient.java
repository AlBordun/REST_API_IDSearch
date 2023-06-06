package OOP.Classes;

public class OrdinaryClient extends Actor {
    public OrdinaryClient(String FirstName, String LastName) {
        super(FirstName, LastName);
    }


    @Override
    public String GetFirstName() {
        return super.FirstName;
    }

    @Override
    public String GetLastName() {
        return super.LastName;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    public void setMakeOrder(boolean makeOrder) {

        super.isMakeOrder = makeOrder;
    }


    public void setTakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }
}
