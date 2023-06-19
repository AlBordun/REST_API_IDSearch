package OOP.View;

import java.util.*;

import OOP.Controller.iGetView;
import OOP.Model.Student;

public class View implements iGetView {
    /***
     * View to print Students in List and a prompt msg for it
     * @param students our studs
     */
    public void printAllStudent(List<Student> students) {
        System.out.println("-----Students List-----");
        for (Student stud : students) {
            System.out.println(stud);

        }
        System.out.println("-----End of list-----");
    }

    @Override
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
