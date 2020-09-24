package uaslp.engineering.labs.list;

import uaslp.engineering.labs.model.Student;

public class LinkedList {

    private Node front;
    private Node tail;
    private int size;

    public enum InsertPosition {
        BEFORE,
        AFTER
    }

    public class Iterator {

        public Node currentNode;

        /**
         * This constructor initializes the iterator at the front of the list
         * so it can travel the whole list
         */
        public Iterator() {
            this.currentNode = front;
        }

        public boolean hasNext() {
            /** If there isn't any node returns null **/
            return currentNode != null;
        }

        public Student next() {
            /** If the list is empty **/
            if (currentNode == null) {
                return null;
            }

            Student currentStudent = currentNode.getStudent();

            currentNode = currentNode.getNext();

            return currentStudent;
        }
    }

    public void add(Student student) {
        /** Initialize a new node with the student **/
        Node newNode = new Node(student);

        /** If the size of the list is 0 **/
        if (size == 0) {
            /** Set front and tail to the new node **/
            front = tail = newNode;
        } else {
            /** Point the tail to the new node and vice versa **/
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    public void delete(Student student) {

    }

    public void delete(int index) {

        if (index < 0 || index > size) {
            return;
        }

        Node actualNode = front;

        for (int counter = 0; counter != index && counter < size; counter++) {
            actualNode = actualNode.getNext();
        }

        if (actualNode == front && actualNode == tail) {
            front = tail = null;
        } else if (actualNode == tail) {
            tail = actualNode.getPrevious();
            actualNode.setPrevious(null);
        } else if (actualNode == front) {
            front = actualNode.getNext();
            actualNode.setNext(null);
        } else {
            actualNode.getNext().setPrevious(actualNode.getPrevious());
            actualNode.getPrevious().setNext(actualNode.getNext());
        }
        size--;
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    /**
     * We need a size variable that tells us the size of the list
     **/
    public int getSize() {
        return size;
    }

    public Student getAt(int index) {
        Node currentNode = front;

        for (int counter = 0; counter < index && counter < size; counter++) {
            currentNode = currentNode.getNext();
        }

        return currentNode != null ? currentNode.getStudent() : null;
    }

    public void insert(Student reference, Student newStudent, InsertPosition insertPosition) {

        if (size == 0) {
            return;
        }

        Node actualNode = front;

        for (; !actualNode.getStudent().equals(reference); actualNode = actualNode.getNext());

        /** Didn't find the reference **/
        if (actualNode == null) {
            return;
        }

        Node newNode = new Node(newStudent);

        if(insertPosition.equals(InsertPosition.BEFORE)) {
            Node previous = actualNode.getPrevious();
            newNode.setNext(actualNode);
            newNode.setPrevious(previous);
            actualNode.setPrevious(newNode);
            if (actualNode.equals(front)) {
                front = newNode;
            } else {
                previous.setNext(newNode);
            }
        } else {
            Node next = actualNode.getNext();
            newNode.setNext(next);
            newNode.setPrevious(actualNode);
            actualNode.setNext(newNode);
            if (actualNode.equals(tail)) {
                tail = newNode;
            }
        }
        size++;
    }
}
