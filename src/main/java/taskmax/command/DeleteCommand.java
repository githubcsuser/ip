package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.task.Task;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param index The one-based index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index - 1; // Convert to zero-based index
    }

    /**
     * Executes the delete command by removing the specified task from the task list,
     * displaying a confirmation message, and updating storage if needed.
     *
     * @param tasks   The task list from which the task will be deleted.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to handle task persistence.
     * @return {@code false} as deleting a task does not terminate the program.
     * @throws TaskmaxException If an error occurs while modifying the task list.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        Task removedTask = tasks.removeTask(index);
        ui.showMessage("Noted. I've removed this task:\n"
                + removedTask.toString()
                + "\nNow you have " + tasks.size() + " tasks in the list.");
        return false;
    }
}
