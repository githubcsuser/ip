package taskmax.command;

import taskmax.exception.TaskmaxException;
import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.task.Task;
import taskmax.ui.Ui;

/**
 * Represents a command to add one or more tasks to the task list.
 */
public class AddCommand extends Command {
    private final Task[] tasksToAdd;

    /**
     * Constructs an AddCommand with one or more tasks.
     *
     * @param tasksToAdd The tasks to be added to the task list.
     */
    public AddCommand(Task... tasksToAdd) {
        this.tasksToAdd = tasksToAdd;
    }

    /**
     * Executes the add command by adding the specified tasks to the task list.
     *
     * @param tasks   The task list containing the tasks.
     * @param ui      The UI instance for displaying messages.
     * @param storage The storage handler for saving task updates.
     * @return False, as this command does not terminate the application.
     * @throws TaskmaxException If an error occurs while adding the tasks.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        StringBuilder response = new StringBuilder("Got it. I've added the following tasks:\n");
        for (Task task : tasksToAdd) {
            tasks.addTask(task);
            response.append("  ").append(task.toString()).append("\n");
        }
        response.append("Now you have ").append(tasks.size()).append(" tasks in the list.");
        ui.showMessage(response.toString());
        return false;
    }

    /**
     * Executes the command for GUI mode.
     *
     * @param tasks   The task list containing the tasks.
     * @param storage The storage handler for saving task updates.
     * @return The response message for the GUI.
     * @throws TaskmaxException If an error occurs while adding the tasks.
     */
    @Override
    public String executeForGUI(TaskList tasks, Storage storage) throws TaskmaxException {
        StringBuilder response = new StringBuilder(Ui.LINE + "\nGot it. I've added the following tasks:\n");
        for (Task task : tasksToAdd) {
            tasks.addTask(task);
            response.append("  ").append(task.toString()).append("\n");
        }
        response.append("Now you have ").append(tasks.size()).append(" tasks in the list.\n").append(Ui.LINE);
        return response.toString();
    }
}