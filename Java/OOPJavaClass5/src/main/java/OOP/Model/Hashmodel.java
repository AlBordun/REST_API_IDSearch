package OOP.Model;

import OOP.Controller.iGetModel;
import OOP.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/***
 * Hashmodel creates hashmap and add a possibility to
 * interact with its containment by obj key(Students list)
 */
public class Hashmodel implements iGetModel {
    private HashMap <Long, Student> students;

    public Hashmodel(HashMap<Long, Student> students) {
        this.students = new HashMap<>(students);
    }

    /***
     * Methods to interract with Student ArrList(Check Methods names)
     * @return students
     */
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }
    public Student findStudentByNumber(Long number){
        return this.students.get(number);
    }
    @Override
    public List<Student> deleteStudentByNumber(List<Student> students, int number) {
        students.remove(findStudentByNumber((long) number));
        return students;
    }
}
