import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FitnessClubTest {

    @Test
    public void testAddCustomer() {
        Lesson lesson = new Lesson("Yoga", "Monday", 9, 20);
        assertTrue(lesson.addCustomer("Alice"));
        assertTrue(lesson.addCustomer("Bob"));
        assertTrue(lesson.addCustomer("Charlie"));
        assertTrue(lesson.addCustomer("David"));
        assertTrue(lesson.addCustomer("Emily"));
        assertFalse(lesson.addCustomer("Frank")); // should be full
        List<String> customers = lesson.getCustomers();
        assertEquals(5, customers.size());
        assertTrue(customers.contains("Alice"));
        assertTrue(customers.contains("Bob"));
        assertTrue(customers.contains("Charlie"));
        assertTrue(customers.contains("David"));
        assertTrue(customers.contains("Emily"));
    }

    @Test
    public void testRemoveCustomer() {
        Lesson lesson = new Lesson("Yoga", "Monday", 9, 20);
        lesson.addCustomer("Alice");
        lesson.addCustomer("Bob");
        lesson.addCustomer("Charlie");
        assertTrue(lesson.removeCustomer("Bob"));
        assertFalse(lesson.removeCustomer("Bob")); // should already be removed
        List<String> customers = lesson.getCustomers();
        assertEquals(2, customers.size());
        assertTrue(customers.contains("Alice"));
        assertFalse(customers.contains("Bob"));
        assertTrue(customers.contains("Charlie"));
    }

    @Test
    public void testIsFull() {
        Lesson lesson = new Lesson("Yoga", "Monday", 9, 20);
        assertFalse(lesson.isFull());
        lesson.addCustomer("Alice");
        lesson.addCustomer("Bob");
        lesson.addCustomer("Charlie");
        lesson.addCustomer("David");
        lesson.addCustomer("Emily");
        assertTrue(lesson.isFull());
    }

    @Test
    public void testSetRating() {
        Lesson lesson = new Lesson("Yoga", "Monday", 9, 20);
        lesson.setRating(4.5);
        assertEquals(4.5, lesson.getRating(), 0.01);
    }

    @Test
    public void testGetNumCustomers() {
        Lesson lesson = new Lesson("Yoga", "Monday", 9, 20);
        assertEquals(0, lesson.getNumCustomers());
        lesson.addCustomer("Alice");
        assertEquals(1, lesson.getNumCustomers());
        lesson.addCustomer("Bob");
        lesson.addCustomer("Charlie");
        assertEquals(3, lesson.getNumCustomers());
        lesson.removeCustomer("Bob");
        assertEquals(2, lesson.getNumCustomers());
    }

}
