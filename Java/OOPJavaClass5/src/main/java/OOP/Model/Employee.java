package OOP.Model;

public class Employee extends Person {
private String PositionHeld;
    public Employee(String firstName, String lastName, int age, String positionHeld) {
        super(firstName, lastName, age);
        PositionHeld = positionHeld;
    }
}

