package OOP.ParametrizedClasses;

import OOP.StudentDomen.User;

import java.util.*;

public class ParamIterator<T extends User> implements Iterator<T> {

    private List<T> AnyList;
    private int counter;

    public ParamIterator(List<T> anyList) {
        AnyList = anyList;
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < AnyList.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        return AnyList.get(counter++);
    }

//    public Iterator<T> getIterator() {
//        return new ParamIterator<T>((List<T>) AnyList);
//    }
//
//    public void printToConsole() {
//        for (Iterator<T> iterator = getIterator(); iterator.hasNext(); ) {
//            System.out.println(iterator.next().toString());
//        }
//    }
}
