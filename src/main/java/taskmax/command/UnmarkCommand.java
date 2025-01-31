package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

/**
 * Represents a command to unmark a task as not done in the task list.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param index The one-based index of the task to be unmarked.
     */
    public UnmarkCommand(int index) {
        this.index = index - 1; // Convert to zero-based index
    }

    /**
     * Executes the unmark command by marking the specified task as not done
     * and displaying a confirmation message.
     *
     * @param tasks   The task list containing the task to be unmarked.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system for task persistence.
     * @return {@code false} as unmarking a task does not terminate the program.
     * @throws TaskmaxException If the index is invalid or an error occurs while unmarking the task.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        tasks.markTask(index, false);
        ui.showMessage("I've unmarked your task.\n"
                + "Don't give up on it yet!");
        return false;
    }
}
