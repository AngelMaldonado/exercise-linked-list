package uaslp.engineering.labs.list;

import uaslp.engineering.labs.model.Student;

public class LinkedList {

    private Node front;
    private Node tail;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {

        public Node currentNode;


        public boolean hasNext() {
            return false;
        }

        public Student next() {
            return null;
        }
    }

    public void add(Student student) {

    }

    public void delete(Student student) {

    }

    public void delete(int index) {

    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public int size() {
        return 0;
    }

    public Student getAt(int index) {
        return null;
    }

    public void insert(Student reference, Student newStudent, InsertPosition insertPosition) {

    }
}
