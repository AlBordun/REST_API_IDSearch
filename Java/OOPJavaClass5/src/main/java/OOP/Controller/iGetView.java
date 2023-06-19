package OOP.Controller;

import OOP.Model.Student;

import java.util.*;

public interface iGetView {
    void printAllStudent(List<Student> students);
    String prompt(String message);
}
