package taskmax.command;

import taskmax.storage.Storage;
import taskmax.storage.TaskList;
import taskmax.ui.Ui;
import taskmax.exception.TaskmaxException;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean execute(TaskList tasks, Ui ui, Storage storage) throws TaskmaxException {
        StringBuilder output = new StringBuilder("Here are the matching tasks in your list:\n");
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(keyword)) {
                output.append((i + 1)).append(". ").append(tasks.get(i)).append("\n");
                found = true;
            }
        }

        if (!found) {
            ui.showMessage("No tasks found matching your search keyword.");
        } else {
            ui.showMessage(output.toString());
        }

        return false;
    }
}
