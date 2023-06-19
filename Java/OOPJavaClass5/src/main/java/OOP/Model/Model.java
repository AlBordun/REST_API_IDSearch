package OOP.Model;

import OOP.Controller.iGetModel;
import OOP.Model.Student;

import java.util.*;

public class Model implements iGetModel {

    private List<Student> students;

    public Model(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    /***
     * Delete student and show msg if it's done
     * @param students list
     * @param number number of student
     * @return students - new list of students
     */
    @Override
    public List<Student> deleteStudentByNumber(List<Student> students, int number) {
        try{
            Student rem = students.remove(number);
            System.out.println("Deleted: " + rem.toString());
        } catch (NullPointerException e) {
            System.out.printf("There is no student in list #%d",number);
        }
        return students;
    }
}
