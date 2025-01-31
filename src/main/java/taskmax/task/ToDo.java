package taskmax.task;

/**
 * Represents a to-do task, which is a task without a specific deadline or time.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with the given description.
     *
     * @param description The description of the to-do task.
     */
    public ToDo(String description) {
        super(description, TaskType.TODO);
    }

    /**
     * Returns the string representation of the to-do task.
     *
     * @return A string representation of the to-do task, prefixed with "[T]".
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
