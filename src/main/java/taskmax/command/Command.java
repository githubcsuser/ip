package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

/**
 * Represents an abstract command that can be executed within the Taskmax application.
 * All specific commands should extend this class and implement the {@code execute} method.
 */
public abstract class Command {

    /**
     * Executes the command, performing the appropriate actions on the task list, UI, and storage.
     *
     * @param tasks   The task list that stores tasks.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage system for saving and loading tasks.
     * @return {@code true} if the command should terminate the program, {@code false} otherwise.
     * @throws TaskmaxException If an error occurs during command execution.
     */
    public abstract boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException;
}
