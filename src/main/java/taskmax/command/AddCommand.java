package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;

import taskmax.task.Task;

import taskmax.ui.Ui;

import taskmax.exception.TaskmaxException;

/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs an AddCommand with the specified task.
     *
     * @param task The task to be added to the task list.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command by adding the task to the task list,
     * displaying a confirmation message, and updating storage if needed.
     *
     * @param tasks   The task list to which the task will be added.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system to handle task persistence.
     * @return false as adding a task does not terminate the program.
     * @throws TaskmaxException If an error occurs while modifying the task list.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        tasks.addTask(task);
        ui.showMessage("Got it. I've added this task:\n  "
                + task.toString()
                + "\nNow you have " + tasks.size() + " tasks in the list.");
        return false;
    }
}
