package OOP;

import OOP.StudentDomen.*;

import java.net.NoRouteToHostException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        /***
         * All numerations are -1 from real number.
         * First list is a class work and was not changed.
         */
        Student s = new Student("Сергей", "Иванов", 22, 110);
        Student s1 = new Student("Владимир", "Владимиров", 23, 105);
        Student s2 = new Student("Дмитрий", "Дмитриев", 23, 101);

        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s);
        listStud.add(s1);
        listStud.add(s2);
        StudentGroup group = new StudentGroup(listStud, 1111);

        for (Student stud : group) {
            System.out.println(stud);
        }
        System.out.println("======================");

        Collections.sort(group.getStudents());
        for (Student stud : group) {
            System.out.println(stud);
        }

        System.out.println("======================");

        /***
         * Second group list
         */

        List<Student> listStud1 = new ArrayList<>();

        listStud1.add(new Student("John", "Doe", 19, 109));
        listStud1.add(new Student("Alex", "Cassidy", 25, 128));
        listStud1.add(new Student("Morgan", "Freeman", 22, 136));
        listStud1.add(new Student("Jessie", "Cook", 23, 171));

        StudentGroup group1 = new StudentGroup(listStud1, 2222);

        for (Student stud1 : group1) {
            System.out.println(stud1);
        }
        System.out.println("======================");
    /***
    *  Creating StudentStream and adding Groups to it
    */
        List<StudentGroup> StreamGroupList = new ArrayList<>();

        StudentStream stream = new StudentStream(StreamGroupList, 0);
        stream.addGroupToStream(group);
        stream.addGroupToStream(group1);
        stream.setStreamGrade(1);
/***
 * Printing different iterrations of groups,sorted and not
 */
        System.out.printf("Stream #%d :\n", stream.getStreamGrade());
        for (StudentGroup stGroup1 : stream) {
            System.out.println(stGroup1.getGroupList().toString());
        }
        System.out.println("======================");

        System.out.printf("Stream #%d :\n", stream.getStreamGrade());
        Collections.sort(stream.getStream());
        for (StudentGroup studGr : stream) {
            System.out.printf(studGr.getGroupList().toString());
        }
        System.out.println("======================");

        /***
         * Third group list
         */
        List<Student> listStud2 = new ArrayList<>();

        listStud2.add(new Student("Bobby", "Kotik", 57, 209));
        listStud2.add(new Student("Jeff", "Bezos", 52, 228));
        listStud2.add(new Student("Elon", "Musk", 55, 236));
        listStud2.add(new Student("Tim", "Cook", 58, 271));


        StudentGroup group2 = new StudentGroup(listStud2, 3333);

//        for (Student stud2 : group2) {
//            System.out.println(stud2);
//            System.out.println("======================");
        /***
         *  Creating StudentStream and adding Group to it
         */
        List<StudentGroup> StreamGroupList1 = new ArrayList<>();
        StudentStream stream1 = new StudentStream(StreamGroupList1, 0);

        stream1.addGroupToStream(group2);
        stream1.setStreamGrade(2);

//            System.out.printf("Stream #%d :\n", stream.getStreamGrade());
//            for (StudentGroup strgroup3 : stream1) {
//                System.out.println(strgroup3.getGroupList().toString());
//                System.out.println("======================");
//}
        /***
         * Only one print for saving space in console
         */
        System.out.printf("Stream #%d :\n", stream1.getStreamGrade());
        Collections.sort(stream1.getStream());
        for (StudentGroup studGr1 : stream1) {
            System.out.printf(studGr1.getGroupList().toString());
        }
    }
}
//    }
