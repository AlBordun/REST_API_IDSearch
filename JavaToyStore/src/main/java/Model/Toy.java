package Model;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int selectionWeight;
    private int priority;

    public Toy(int id, String name, int selectionWeight) {
        this.id = id;
        this.name = name;
        this.selectionWeight = selectionWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSelectionWeight(int selectionWeight) {
        this.selectionWeight = selectionWeight;
    }

    public String getName() {
        return name;
    }

    public double getSelectionWeight() {
        return selectionWeight;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Toy toy) {
        return Integer.compare(this.priority, toy.getPriority());
    }

    public String toString() {
        return "Toy{" +
                "Id='" + getId() + '\'' +
                ",Name='" + getName() + '\'' +
                ",Weight =" + getSelectionWeight() + '\'' +
                '}';
    }
}


