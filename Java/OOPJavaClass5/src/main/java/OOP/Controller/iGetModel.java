package OOP.Controller;

import OOP.Model.Student;

import java.util.*;

public interface iGetModel {
    public List<Student> getAllStudents();
    public List<Student> deleteStudentByNumber(List<Student> students, int number);
}
