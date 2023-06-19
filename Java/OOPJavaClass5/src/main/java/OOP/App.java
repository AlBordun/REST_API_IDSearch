package OOP;

import OOP.Controller.Controller;
import OOP.Controller.iGetModel;
import OOP.Controller.iGetView;
import OOP.Model.FileModel;
import OOP.Model.Model;
import OOP.Model.Student;
import OOP.View.View;

import java.util.*;

public class App {
    public static void main(String[] args) {

        List<Student> listStud = new ArrayList<Student>();

        Student s = new Student("Сергей", "Иванов", 22, 110);
        Student s1 = new Student("Владимир", "Владимиров", 25, 105);
        Student s2 = new Student("Дмитрий", "Дмитриев", 23, 101);
        Student es = new Student("John","Wick",41,301);
        Student es1 = new Student("John","Silverhand",38,312);
        Student es2 = new Student("Walter","White",62,367);

        listStud.add(s);
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(es);
        listStud.add(es1);
        listStud.add(es2);

        //        fileModel.saveAllStudentToFile(listStud);
//        FileModel fileModel = new FileModel("StudentsDB.txt");
        Model model = new Model(listStud);
//        iGetModel newFModel = fileModel;
        iGetView view = new View();



        Controller controller = new Controller(view, model);
        controller.update();
        controller.run();

        //        controller.update();
//        Model model = new Model(listStud);
//        View view = new View();
//
//        Controller controller = new Controller(view, model);


    }
}
