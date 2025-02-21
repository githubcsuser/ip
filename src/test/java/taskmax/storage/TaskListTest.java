package taskmax.storage;
import taskmax.task.ToDo;
import taskmax.exception.TaskmaxException;

import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskListTest {
    @Test
    void testMarkTaskAsDone() throws TaskmaxException {
        TaskList taskList = new TaskList(List.of(new ToDo("Test Task", 1)));

        taskList.get(0).markAsDone();
        assertTrue(taskList.get(0).isDone());
    }
}
