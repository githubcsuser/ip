package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

/**
 * Represents a command to mark a task as done in the task list.
 */
public class MarkCommand extends Command {
    private final int index;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param index The one-based index of the task to be marked as done.
     */
    public MarkCommand(int index) {
        this.index = index - 1; // Convert to zero-based index
    }

    /**
     * Executes the mark command by marking the specified task as done
     * and displaying a confirmation message.
     *
     * @param tasks   The task list containing the task to be marked.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system for task persistence.
     * @return {@code false} as marking a task does not terminate the program.
     * @throws TaskmaxException If the index is invalid or an error occurs while marking the task.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        tasks.markTask(index, true);
        ui.showMessage("Nice! I've marked your task as done.\n"
                + "Keep up the good work!");
        return false;
    }
}
