package OOP.Controller;

import OOP.Model.Student;

import java.util.*;

public class Controller {
    private iGetView view;
    private iGetModel model;
    private List<Student> students;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    }

    public void getAllStudents() {
        students = model.getAllStudents();
    }

    /***
     * Bool for Students list is it empty or not
     * @return true ot false
     */
    public boolean testData() {
        if (students.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /***
     * Data check in List
     */
    public void update() {

//                               MVP
        getAllStudents();
        if (testData()) {
            view.printAllStudent(students);
        } else {
            System.out.println("empty data");
        }


//                               MVC
//        view.printAllStudent(model.getAllStudents());
    }

    /***
     * Commands run method;
     */
    public void run() {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    getAllStudents();
                    update();
                    break;
                case DELETE:
                    int count = Integer.parseInt(view.prompt("Enter student's number: "));
                    if ((count)> students.size()) {
                        System.out.println("No student found,try again");
                        break;
                    }
                    model.deleteStudentByNumber(students,count);

            }

        }
    }
}
