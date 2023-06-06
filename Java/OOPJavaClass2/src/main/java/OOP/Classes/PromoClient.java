package OOP.Classes;

import OOP.Interfaces.IActorBehaviour;
import OOP.Interfaces.IReturnBehaviour;

public class PromoClient extends Actor implements IReturnBehaviour {
    private int promoClientsNumber;
    static int promoClientsAmount;
    final static int PromoClientLimit = 2;

    static {
        promoClientsAmount = 0;
    }

    public PromoClient(String FirstName,String LastName, int currentPromoNumber) throws ClientsLimit {
        super(FirstName,LastName);
        this.promoClientsNumber = currentPromoNumber;
        if (promoClientsAmount == PromoClientLimit) {
            StringBuilder sb = new StringBuilder();
            sb.append("Достигнуто максимальное количество клиентов, участвующих в акции: ").append(PromoClientLimit);
            throw new ClientsLimit(sb.toString());
        }
        promoClientsAmount++;
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
        public void setMakeOrder ( boolean makeOrder){
            this.isMakeOrder = makeOrder;
        }


        @Override
        public void setTakeOrder ( boolean pickUpOrder){
            this.isTakeOrder = pickUpOrder;
        }


        @Override
        public boolean isMakeOrder () {
            return this.isMakeOrder;
        }

        @Override
        public boolean isTakeOrder () {
            return this.isTakeOrder;
        }

        @Override
        public Actor getActor () {
            return this;
        }

        @Override
        public String toString () {
            return "PromoClient{" +
                    "name='" + GetFirstName() +" "+ GetLastName() + '\'' +
                    '}';
        }

        @Override
        public boolean isGoodsRefundable (IActorBehaviour client){
            if (((PromoClient) client).isTakeOrder) {
                return true;
            }
            return false;
        }

        @Override
        public void getReturnOrderEnqueue(IActorBehaviour client){
            client.setTakeOrder(true);
        }

        @Override
        public boolean isGetRefunds (IActorBehaviour client){
            return false;
        }
    }

