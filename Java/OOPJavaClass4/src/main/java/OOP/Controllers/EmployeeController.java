package OOP.Controllers;

import OOP.Services.EmployeeService;
import OOP.StudentDomen.Employee;
import OOP.StudentDomen.User;

public class EmployeeController implements iUserController<Employee> {

    private final EmployeeService empService = new EmployeeService();

    @Override
    public void Create(String firstName, String lastName, int age) {
    }

    public <T extends Employee> void paySalary(T User) {
        System.out.println(User.getFirstName() + " " + User.getLastName() + " " + "salary was paid for amount of 10k$");
    }
}
