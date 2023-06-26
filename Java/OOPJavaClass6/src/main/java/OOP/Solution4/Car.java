package OOP.Solution4;

public class Car implements Engine {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
    public void start() {
        engine.start();
    }
}
