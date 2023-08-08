package Algoritms;

import java.util.Iterator;

public class Lists {
    public class Main {
        public static void main(String[] args) {
            SingleLinkList<List> List = new SingleLinkList<>();

            List.addToEnd(new List("a"));
            List.addToEnd(new List("b"));
            List.addToEnd(new List("c"));
            List.addToEnd(new List("d"));
            List.addToEnd(new List("e"));

            for (Object contact : List) {
                System.out.println(contact);
            }
            List.reverse();


            for (Object contact : List) {
                System.out.println(contact);
            }
        }

        static class List {

            String string;


            public List(String string) {
                this.string = string;
            }

            @Override
            public String toString() {
                return "{" +
                        "" + string + '\'' +
                        '}';
            }
        }

        /**
         * Класс списка
         *
         * @param <T>
         */
        public static class SingleLinkList<T> implements Iterable {
            ListItem<T> head;
            ListItem<T> tail;

            @Override
            public Iterator iterator() {
                return new Iterator<T>() {
                    ListItem<T> current = head;

                    @Override
                    public boolean hasNext() {
                        return current != null;
                    }

                    @Override
                    public T next() {
                        T data = current.data;
                        current = current.next;
                        return data;
                    }
                };
            }

            /**
             * Класс отдельного элемента
             *
             * @param <T>
             */
            private static class ListItem<T> {
                T data;
                ListItem<T> next;
            }


            public boolean isEmpty() {
                return head == null;
            }


            public void addToEnd(T item) {


                ListItem<T> newItem = new ListItem<>();
                newItem.data = item;


                if (isEmpty()) {
                    head = newItem;
                    tail = newItem;


                } else {
                    tail.next = newItem;
                    tail = newItem;
                }
            }


            public void reverse() {
                if (!isEmpty() && head.next != null) {
                    tail = head;
                    ListItem<T> current = head.next;
                    head.next = null;
                    while (current != null) {
                        ListItem<T> next = current.next;
                        current.next = head;
                        head = current;
                        current = next;
                    }
                }
            }
        }
    }
}
