package OOP.Controllers;

import OOP.StudentDomen.Student;
import OOP.Services.StudentService;

public class StudentController implements iUserController<Student>{
    private final StudentService dataservice = new StudentService();
    @Override
    public void Create(String firstName, String lastName, int age) {
    }

}
