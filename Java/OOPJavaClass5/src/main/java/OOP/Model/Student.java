package OOP.Model;

public class Student extends Person implements Comparable<Student> {
    private long StudentID;
    /***
     * Grade-Курс студента.
     */

    public Student(String firstName, String lastName, int age, long studentID) {
        super(firstName, lastName, age);
        StudentID = studentID;

    }

    public long getStudentID() {
        return StudentID;
    }

    public void setStudentID(long studentID) {
        StudentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getLastName() + '\'' +
                ", age=" + super.getAge() + '\'' +
                ", studentID=" + StudentID + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student object) {
        if (this.getAge() == object.getAge()) {
            if (this.StudentID == object.StudentID) {
                return 0;
            }
            if (this.StudentID < object.StudentID) {
                return -1;
            }
            return 1;
        }
        if (this.getAge() < object.getAge()) {
            return -1;
        }
        return 1;
    }
}
//    @Override
//    public int compareTo(Student ID) {
//        if (this.StudentID == ID.StudentID) {
//            return 0;
//        }
//        if (this.StudentID < ID.StudentID) {
//            return -1;
//        }
//        return 1;
//    }
//}
