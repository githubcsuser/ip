package taskmax.storage;

import taskmax.exception.TaskmaxException;
import taskmax.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks and provides methods to manage them.
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
     * Adds a task to the task list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the task list at the specified index.
     *
     * @param index The index of the task to be removed.
     * @return The removed task.
     * @throws TaskmaxException If the index is invalid.
     */
    public Task removeTask(int index) throws TaskmaxException {
        if (index < 0 || index >= tasks.size()) {
            throw new TaskmaxException("Please enter a number of an existing task so I can find it in the list!");
        }
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
        if (index < 0 || index >= tasks.size()) {
            throw new TaskmaxException("Please enter a number of an existing task so I can find it in the list!");
        }
        if (isDone) {
            tasks.get(index).markAsDone();
        } else {
            tasks.get(index).markAsNotDone();
        }
    }

    /**
     * Returns the list of tasks.
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
        if (index < 0 || index >= tasks.size()) {
            throw new TaskmaxException("Please enter a number of an existing task so I can find it in the list!");
        }
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
     * @return {@code true} if the task list is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
