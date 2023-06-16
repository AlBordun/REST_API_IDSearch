package OOP.Controllers;

import OOP.Services.TeacherService;
import OOP.StudentDomen.Teacher;

public class TeacherController implements iUserController {
    private final TeacherService teachService = new TeacherService();
    @Override
    public void Create(String firstName, String lastName, int age) {

    }
}
