package OOP.Services;

import OOP.StudentDomen.Teacher;
import OOP.ParametrizedClasses.UserComparator;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements iUserService<Teacher> {

    private List<Teacher> Teachers;

    public TeacherService() {
        Teachers = new ArrayList<Teacher>();
    }

    @Override
    public List<Teacher> getAll() {
        return Teachers;
    }

    @Override
    public void Create(String firstName, String lastName, int age) {
        Teacher teacher0 = new Teacher("Robert", "Martin", 71, 1, "The Highest Degree u can ever imagine");
        Teachers.add(teacher0);
    }

    public List<Teacher> getSortedByFullNameTeacherList() {
        List<Teacher> NewListOfTeachersForSorting = new ArrayList<>();
        NewListOfTeachersForSorting.sort(new UserComparator<Teacher>());
        return NewListOfTeachersForSorting;
    }
}
