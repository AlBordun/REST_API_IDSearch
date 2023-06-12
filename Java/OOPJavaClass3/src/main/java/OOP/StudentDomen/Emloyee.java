package OOP.StudentDomen;

public class Emloyee {
    public class Employee extends User {
        private String PositionHeld;
        public Employee(String firstName, String secondName, int age, String positionHeld) {
            super(firstName, secondName, age);
            PositionHeld = positionHeld;
        }
    }
        }
