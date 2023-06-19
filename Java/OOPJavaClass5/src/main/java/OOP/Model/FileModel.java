package OOP.Model;


import OOP.Controller.iGetModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileModel implements iGetModel {
    private String fileName;
    private List<Student> students;
    public FileModel (String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public void readAllStudentsFromFile()
    {
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student stud = new Student(param[0], param[1], Integer.parseInt(param[2]), Long.parseLong(param[3]));
                students.add(stud);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getFirstName()+" "+pers.getLastName()+" "+pers.getAge()+" "+pers.getStudentID());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        readAllStudentsFromFile();
        return students;
    }

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
