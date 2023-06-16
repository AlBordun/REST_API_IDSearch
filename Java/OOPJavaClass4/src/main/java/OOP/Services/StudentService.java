package OOP.Services;
import OOP.StudentDomen.User;
import OOP.ParametrizedClasses.ParamIterator;
import OOP.StudentDomen.Student;
import OOP.ParametrizedClasses.UserComparator;
import OOP.StudentDomen.User;

import java.util.*;

public class StudentService<T extends User> implements iUserService<Student> {
    private int count;
    private List<Student> Students;

    public StudentService() {
        Students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return Students;
    }

    @Override
    public void Create(String firstName, String lastName, int age) {
        Student student = new Student(firstName, lastName, age, count);
        count++;
        Students.add(student);

    }

    public List<Student> getSortedByFullNameStudentList() {
        List<Student> NewListofStudentsForSorting = new ArrayList<Student>();
        NewListofStudentsForSorting.sort(new UserComparator<Student>());
        return NewListofStudentsForSorting;
    }
    public Iterator<Student> getParamIterator() {
        return new ParamIterator<Student>((List<Student>) Students);
    }
    public void printToConsole() {
        for (Iterator<Student> it = this.getParamIterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }
}
