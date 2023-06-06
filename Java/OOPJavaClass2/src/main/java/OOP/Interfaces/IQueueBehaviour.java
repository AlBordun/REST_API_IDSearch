package OOP.Interfaces;

import OOP.Classes.Actor;
import java.util.*;
public interface IQueueBehaviour {
    void takeInQueue(IActorBehaviour actor);
    void releaseFromQueue();
    void takeOrder();
    void giveOrder();

}
