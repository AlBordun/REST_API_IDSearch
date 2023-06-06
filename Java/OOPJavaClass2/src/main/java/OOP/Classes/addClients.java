package OOP.Classes;

import OOP.Interfaces.IActorBehaviour;

import java.util.ArrayList;
import java.util.List;

public class addClients {
    Market market = new Market();
    public List<IActorBehaviour> clients = new ArrayList<>();
//    public List<IActorBehaviour> getClientsList (){
//        return this.clients;
//    }
    /**
     * Append clients to acceptToMarket method.
     */
//    public void addlient(IActorBehaviour clients){
//        this.clients.add(clients);
//    }
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
