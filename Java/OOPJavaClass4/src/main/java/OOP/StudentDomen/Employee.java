package OOP.StudentDomen;

public class Employee extends User {
private String PositionHeld;
    public Employee(String firstName, String lastName, int age, String positionHeld) {
        super(firstName, lastName, age);
        PositionHeld = positionHeld;
    }
}

