package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Animal {
    private String name;
    private int id;
    private Date dateOfBirth;
    private String commands;
    private String classOfAnimal;
    private static int counter = 0;
    static {
        // Инициализация формата даты в статическом блоке
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    private static SimpleDateFormat dateFormat;
    public Animal(String name, int id, String dateString, String commands, String classOfAnimal) {
        this.name = name;
        this.id = ++counter;
//        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
        this.classOfAnimal = classOfAnimal;
        try {
            this.dateOfBirth = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    private static int getNextId() {
        return ++counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassOfAnimal() {
        return classOfAnimal;
    }

    public void setClassOfAnimal(String classOfAnimal) {
        this.classOfAnimal = classOfAnimal;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public String toString() {
        return getId() + " " + getName() + " " + getDateOfBirth() + " " + getClassOfAnimal();
    }



//        public List<Commands> getCommands() {
//        return commands;
//    }
//
//    public void setCommands(List<Commands> commands) {
//        this.commands = commands;
//    }

}
