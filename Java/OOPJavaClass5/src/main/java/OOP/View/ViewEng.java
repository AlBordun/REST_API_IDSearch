package OOP.View;

import OOP.Controller.iGetView;
import OOP.Model.Student;

import java.util.List;
import java.util.Scanner;

public class ViewEng implements iGetView {
    /***
     * Same as View just for eng
     */
    @Override
    public void printAllStudent(List<Student> students) {
        System.out.println("-----English student List-----");
        for (Student stud : students) {
            System.out.println(stud);
        }
        System.out.println("-----End of list-----");

    }


    @Override
    public String prompt(String message) {
    Scanner in = new Scanner(System.in);
        System.out.println(message);
        return  in.nextLine();
    }
}
