package OOP.Classes;

public class SpecialClient extends Actor {

    private int IdVip;

    public SpecialClient(String FirstName, String LastName,int IdVip) {
        super(FirstName, LastName);
        this.IdVip = IdVip;
    }

    @Override
    public String GetFirstName() {
        return FirstName;
    }

    @Override
    public String GetLastName() {
        return LastName;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        isTakeOrder = pickUpOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public Actor getActor() {
        return this;
    }

    public int getIdVip() {
        return IdVip;
    }
}
