package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by displaying all tasks in the task list.
     *
     * @param tasks   The task list containing the tasks to be displayed.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system (not used in this command).
     * @return {@code false} as listing tasks does not terminate the program.
     * @throws TaskmaxException If an error occurs while retrieving the task list.
     */
    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        if (tasks.isEmpty()) {
            ui.showMessage("Your task list is empty! Start adding tasks to see them in the list!.");
        } else {
            StringBuilder output = new StringBuilder("\nHere are the tasks in your list:\n");
            for (int i = 0; i < tasks.size(); i++) {
                output.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
            }
            ui.showMessage(output.toString());
        }
        return false;
    }
}
