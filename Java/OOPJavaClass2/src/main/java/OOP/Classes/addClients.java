package OOP.Classes;

import OOP.Interfaces.IActorBehaviour;
import  OOP.Interfaces.IMarketBehaviour;
import OOP.Classes.*;

import java.util.ArrayList;
import java.util.List;

public class addClients {
    private List<IActorBehaviour> clients = new ArrayList<>();
    Market market = new Market();
//    public List<IActorBehaviour> getClientsList (IActorBehaviour actor){
//        return clients;
//    }
    /**
     * Append clients to acceptToMarket method.
     */

    public void add(IActorBehaviour actor) {
        for (IActorBehaviour client :
                clients) {
            market.acceptToMarket(client);
        }
        market.acceptToMarket(new TaxService());


        market.Update();
    }
//    public IActorBehaviour getClientsByName (String name) {
//        for (IActorBehaviour actor : clients) {
//            if (actor.getActor().GetFirstName().equals(name))
//            {
//                return actor;
//            }
//        }
//        return null;
//    }
}
