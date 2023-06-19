package OOP.Model;

import OOP.Model.Person;

public class Teacher extends Person {
    private long TeacherID;
    private String ScienceDegree;
    public Teacher(String firstName, String lastName, int age, long teacherID, String scienceDegree ) {
        super(firstName, lastName, age);
        TeacherID = teacherID;
        ScienceDegree = scienceDegree;

    }

    public long getTeacherID() {
        return TeacherID;
    }
    public void setTeacherID(long teacherID) {
        TeacherID = teacherID;
    }
    public String getScienceDegree() {
        return ScienceDegree;
    }

    public void setScienceDegree(String scienceDegree) {
        ScienceDegree = scienceDegree;
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getLastName() + '\'' +
                ", age=" + super.getAge() + '\'' +
                ", TeacherID=" + TeacherID  +  '\'' +
                ", ScienceDegree=" + ScienceDegree  + '\'' +
                '}';
    }
}
