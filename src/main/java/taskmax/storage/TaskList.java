package taskmax.storage;

import taskmax.exception.TaskmaxException;
import taskmax.task.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a list of tasks and provides methods to manipulate them.
 */
public class TaskList {
    private final List<Task> tasks;

    /**
     * Constructs an empty task list.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a task list with a given list of tasks.
     *
     * @param tasks The list of tasks to initialise the task list with.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds one or more tasks to the task list.
     *
     * @param tasks The tasks to be added.
     */
    public void addTask(Task... tasks) {
        this.tasks.addAll(Arrays.asList(tasks));
    }

    /**
     * Removes a task from the task list at the specified index.
     *
     * @param index The index of the task to be removed.
     * @return The removed task.
     * @throws TaskmaxException If the index is invalid.
     */
    public Task removeTask(int index) throws TaskmaxException {
        validateIndex(index);
        return tasks.remove(index);
    }

    /**
     * Marks a task as done or not done at the specified index.
     *
     * @param index  The index of the task to be marked.
     * @param isDone {@code true} to mark as done, {@code false} to mark as not done.
     * @throws TaskmaxException If the index is invalid.
     */
    public void markTask(int index, boolean isDone) throws TaskmaxException {
        validateIndex(index);
        if (isDone) {
            tasks.get(index).markAsDone();
        } else {
            tasks.get(index).markAsNotDone();
        }
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Retrieves a task at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     * @throws TaskmaxException If the index is invalid.
     */
    public Task get(int index) throws TaskmaxException {
        validateIndex(index);
        return tasks.get(index);
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return The number of tasks.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Checks if the task list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    /**
     * Validates whether the given index is within the valid range.
     *
     * @param index The index to validate.
     * @throws TaskmaxException If the index is out of bounds.
     */
    private void validateIndex(int index) throws TaskmaxException {
        if (index < 0 || index >= tasks.size()) {
            throw new TaskmaxException("Invalid task number! Please enter a valid task index.");
        }
    }
}