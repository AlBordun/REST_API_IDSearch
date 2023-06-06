package OOP.Classes;

import OOP.Interfaces.IActorBehaviour;

public class TaxService implements IActorBehaviour {
    private String name;
    protected String FirstName;
    protected String LastName;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    public TaxService() {
        this.name = "Tax audit";
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

    public String GetFirstName() {
        return FirstName;
    }

    public String GetLastName() {
        return LastName;
    }

    @Override
    public Actor getActor() {
        return new OrdinaryClient(this.GetFirstName(),GetLastName());
    }
}
