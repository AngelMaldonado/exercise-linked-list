package uaslp.engineering.labs.list;

import org.junit.jupiter.api.Test;
import uaslp.engineering.labs.model.Student;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {


    @Test
    /** Test when list is initialized **/
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        LinkedList list = new LinkedList();

        // When:
        int size = list.getSize();

        // Then:
        assertEquals(0, size);
    }

    @Test
    /** When a new element is inserted at the new list **/
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        /** Initialize a new list and a student **/
        LinkedList list = new LinkedList();
        Student student = new Student("Ivan");

        // When:
        list.add(student);

        // Then:
        assertEquals(1, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        /** Initialize the list and add the 3 students **/
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.delete(0);

        // Then:
        assertEquals(2, list.getSize());
        assertEquals(list.getAt(0).getName(), "Israel");
        assertEquals(list.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.delete(2);

        // Then:
        assertEquals(2, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.delete(1);

        // Then:
        assertEquals(2, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.delete(-1);

        // Then:
        assertEquals(3, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
        assertEquals(list.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.delete(4);

        // Then:
        assertEquals(3, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
        assertEquals(list.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Ivan");

        list.add(reference);
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Lupita");
        assertEquals(list.getAt(1).getName(), "Ivan");
        assertEquals(list.getAt(2).getName(), "Israel");
        assertEquals(list.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Francisco");

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(reference);

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
        assertEquals(list.getAt(2).getName(), "Lupita");
        assertEquals(list.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Israel");

        list.add(new Student("Ivan"));
        list.add(reference);
        list.add(new Student("Francisco"));

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Lupita");
        assertEquals(list.getAt(2).getName(), "Israel");
        assertEquals(list.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Ivan");

        list.add(reference);
        list.add(new Student("Israel"));
        list.add(new Student("Francisco"));

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Lupita");
        assertEquals(list.getAt(2).getName(), "Israel");
        assertEquals(list.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Francisco");

        list.add(new Student("Ivan"));
        list.add(new Student("Israel"));
        list.add(reference);

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
        assertEquals(list.getAt(2).getName(), "Francisco");
        assertEquals(list.getAt(3).getName(), "Lupita");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        LinkedList list = new LinkedList();
        Student reference = new Student("Israel");

        list.add(new Student("Ivan"));
        list.add(reference);
        list.add(new Student("Francisco"));

        // When:
        list.insert(reference, new Student("Lupita"), LinkedList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, list.getSize());
        assertEquals(list.getAt(0).getName(), "Ivan");
        assertEquals(list.getAt(1).getName(), "Israel");
        assertEquals(list.getAt(2).getName(), "Lupita");
        assertEquals(list.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        LinkedList list = new LinkedList();

        // When:
        LinkedList.Iterator iterator = list.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        LinkedList list = new LinkedList();

        list.add(new Student("Ivan"));

        // When:
        LinkedList.Iterator iterator = list.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }
}
