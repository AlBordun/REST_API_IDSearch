package OOP.Services;

import java.util.*;

import OOP.ParametrizedClasses.ParamIterator;
import OOP.StudentDomen.Employee;
import OOP.ParametrizedClasses.UserComparator;
import OOP.StudentDomen.Student;
import OOP.StudentDomen.User;

public class EmployeeService<T extends User> implements iUserService<Employee> {
    private String positionHeld;
    private List<Employee> Employes;

    public EmployeeService() {
        Employes = new ArrayList<Employee>();
    }

    @Override
    public List<Employee> getAll() {
        return Employes;
    }

    @Override
    public void Create(String firstName, String lastName, int age) {
        Employee employee = new Employee(firstName,lastName,age,positionHeld);
        Employes.add(employee);
    }

    public List<Employee> getSortedByFullNameEmployeeList() {
        List<Employee> NewListofEmployeeForSorting = new ArrayList<Employee>();
        NewListofEmployeeForSorting.sort(new UserComparator<Employee>());
        return NewListofEmployeeForSorting;
    }

    public Iterator<Employee> getParamIterator() {
        return new ParamIterator<Employee>((List<Employee>) Employes);
    }

    public void printToConsole() {
        for (Iterator<Employee> it = this.getParamIterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }
}
