package taskmax.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskTest {
    @Test
    void testMarkAsDone() {
        Task task = new ToDo("Finish CS2103", 1);
        assertFalse(task.isDone());

        task.markAsDone();
        assertTrue(task.isDone());
    }

    @Test
    void testMarkAsNotDone() {
        Task task = new ToDo("Test Task", 1);
        task.markAsDone();
        task.markAsNotDone();
        assertFalse(task.isDone(), "Task should be marked as not done.");
    }
}
