package OOP.Classes;

import OOP.Interfaces.IActorBehaviour;
import OOP.Interfaces.IMarketBehaviour;
import OOP.Interfaces.IQueueBehaviour;
import OOP.Interfaces.IReturnBehaviour;

import java.util.ArrayList;
import java.util.List;

public class Market implements IMarketBehaviour, IQueueBehaviour, IReturnBehaviour {

    private List<IActorBehaviour> queue;

    //    private List<IActorBehaviour> clients = new ArrayList<>();
    public Market() {
        this.queue = new ArrayList<IActorBehaviour>();
    }
//    public void add1(IActorBehaviour client) {
//        Market market = new Market();
//        for (IActorBehaviour actor :
//                clients) {
//            market.acceptToMarket(actor);
//        }
//        market.acceptToMarket(new TaxService());
//
//
//        market.Update();
//    }

    /**
     * Accept given customer from IActorBehaviour with addClient Class.
     */
    @Override
    public void acceptToMarket(IActorBehaviour actor) {
        System.out.println(actor.getActor().GetFirstName() + " " + actor.getActor().GetLastName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }

    /**
     * Place a customer in queue with ArrayList.
     */
    @Override
    public void takeInQueue(IActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().GetFirstName() + " " + actor.getActor().GetLastName() + " клиент добавлен в очередь ");
    }

    /**
     * Release from List.
     */
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.GetFirstName() + " " + actor.getActor().GetLastName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }

    }

    /**
     * Updates State of methods.
     */
    @Override
    public void Update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    /**
     * Execute an order
     */
    @Override
    public void giveOrder() {
        for (IActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().GetFirstName() + " " + actor.getActor().GetLastName() + " клиент получил свой заказ ");
            }
        }
    }

    /**
     * If Customer took an order (isTakeOrder)
     * we put him new List,remove from queue and then release from Market.
     */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (IActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().GetFirstName() + " " + actor.getActor().GetLastName() + " клиент ушел из очереди ");
            }

        }
        releaseFromMarket(releaseActors);
    }

    /**
     * Take an order if customer don't have one
     */
    @Override
    public void takeOrder() {
        for (IActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().GetFirstName() + " " + actor.getActor().GetLastName() + " клиент сделал заказ ");

            }
        }
    }

    /**
     * Refund check
     */
    @Override
    public boolean isGoodsRefundable(IActorBehaviour actor) {
        return false;
    }

    /**
     * Put customer in queue to get order
     */
    @Override
    public void getReturnOrderEnqueue(IActorBehaviour actor) {
        actor.setTakeOrder(true);
        if (actor.getClass().getName() != "PromoClient") {
            giveOrder();
            releaseFromQueue();
        }
    }

    /**
     * Check if customer got refund
     */
    @Override
    public boolean isGetRefunds(IActorBehaviour actor) {
        return false;
    }
}
