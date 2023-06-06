package OOP.Interfaces;

import OOP.Classes.Actor;
import java.util.*;

public interface IMarketBehaviour {
    void acceptToMarket(IActorBehaviour actor);
    void releaseFromMarket(List<Actor> actors);
    void Update();

}
