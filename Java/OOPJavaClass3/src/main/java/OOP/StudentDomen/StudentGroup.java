package OOP.StudentDomen;

import java.util.*;

public class StudentGroup  implements Iterable<Student>,Comparable<StudentGroup>{
    /***
     * Fields,Values,Constructor,etc.
     */
    private List<Student> Students;
    private long GroupID;
    public StudentGroup(List<Student> students, int groupID) {
       Students = students;
       GroupID = groupID;
    }
    public List<Student> getStudents() {
        return Students;
    }
    public void setStudents(List<Student> students) {
        Students = students;
    }
    public long getGroupID() {
        return GroupID;
    }

    public void setGroupID(long groupID) {
        GroupID = groupID;
    }

//    @Override
//    public Iterator<Student> iterator() {
//        return new StudentGroupIterator(Students);
//    }

    /***
     * Iterator for Students
     */
    @Override
    public Iterator<Student> iterator(){
        return new Iterator<Student>()
        {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<Students.size();
            }
            @Override
            public Student next() {
                if(!hasNext())
                {
                    return null;
                }
                return Students.get(index++);
            }
        };
    }
    @Override
    public String toString() {
        return "StudentGroup{" +
                "group=" + Students +
                ", groupID=" + GroupID +
                '}';
    }

    /***
     * StringBuilder for printing in main class
     */
    public StringBuilder getGroupList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Group: ").append(this.getGroupID()).append(" size = ")
                .append(this.getStudents().size())
                .append("\n");
        for (Student stud : this
        ) {
            sb.append(stud.toString()).append("\n");
        }
        return sb;
    }

    /***
     * Comparing groups with IDs and Sizes
     * @param object1 the object to be compared.
     */
    @Override
    public int compareTo(StudentGroup object1) {
        System.out.println(getGroupID()+" - "+object1.getGroupID());
        if (this.getStudents().size() == object1.getStudents().size()) {
            if(this.getGroupID() == object1.getGroupID())
            return 0;
        }
        if (this.getStudents().size() > object1.getStudents().size()) {
            if(this.getGroupID() > object1.getGroupID())
            return -1;
        }
        return 1;
    }
}
