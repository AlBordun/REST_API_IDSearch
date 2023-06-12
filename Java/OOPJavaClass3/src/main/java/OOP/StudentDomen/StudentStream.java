package OOP.StudentDomen;

import java.util.*;


public class StudentStream implements Iterable<StudentGroup> {
    /***
     * Fields,Values,Constructor,etc.
     */
    private List<StudentGroup> Stream;

    private int StreamGrade;

    public StudentStream(List<StudentGroup> stream,int streamGrade) {
        Stream = stream;
        StreamGrade = streamGrade;
    }

    public int getStreamGrade() {
        return StreamGrade;
    }

    public void setStreamGrade(int streamGrade) {
        StreamGrade = streamGrade;
    }

    public List<StudentGroup> getStream() {
        return Stream;
    }

    public void setStream(List<StudentGroup> stream) {
        Stream = stream;
    }

    public void addGroupToStream(StudentGroup group) {
        this.Stream.add(group);
    }

    /***
     * Iterator for Groups in Stream
     */
    public Iterator<StudentGroup> iterator() {
        return new Iterator<StudentGroup>() {
            private int counter;

            @Override
            public boolean hasNext() {
                return (counter < Stream.size());
            }

            @Override
            public StudentGroup next() {
                if (!hasNext()) {
                    return null;
                }
                return Stream.get(counter++);
            }
        };
    }
//    @Override
//    public String toString() {
//        return "StudentStream{" +
//                "stream=" + Stream +
//                '}';
//    }

}

