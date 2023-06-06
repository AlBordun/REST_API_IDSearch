package OOP.Interfaces;

import OOP.Classes.Actor;

import java.util.*;

public interface IActorBehaviour {
    /**
     * @param makeOrder set the possibility to MAKE an order.
     */
    void setMakeOrder(boolean makeOrder);

    /**
     * @param pickUpOrder set the possibility to TAKE an order.
     */
    void setTakeOrder(boolean pickUpOrder);

    /**
     * @return true if customer can
     * MAKE and order.
     */
    boolean isMakeOrder();

    /**
     * @return true if customer can
     * TAKE and order.
     */
    boolean isTakeOrder();

    /**
     * Actor class example Getter
     */
    Actor getActor();
}
