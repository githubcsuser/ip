package taskmax.storage;

import taskmax.task.Task;
import taskmax.task.ToDo;
import taskmax.task.Deadline;
import taskmax.task.Event;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import java.time.format.DateTimeFormatter;

/**
 * Handles the storage of tasks in a file.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a Storage instance with the specified file path.
     *
     * @param filePath The file path where tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the given list of tasks to a file.
     *
     * @param tasks The list of tasks to be saved.
     * @throws IOException If an error occurs while writing to the file.
     */
    public void saveTasks(List<Task> tasks) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(serializeTask(task) + System.lineSeparator());
            }
        }
    }

    /**
     * Loads tasks from the file and returns them as a list.
     *
     * @return A list of tasks loaded from the file.
     * @throws IOException If an error occurs while reading the file.
     */
    public List<Task> loadTasks() throws IOException {
        File file = new File(filePath);
        List<Task> tasks = new ArrayList<>();

        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = deserializeTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        }
        return tasks;
    }

    /**
     * Serializes a task into a string format for storage.
     *
     * @param task The task to be serialized.
     * @return A string representation of the task.
     */
    private String serializeTask(Task task) {
        String typeCode = "";
        String extraData = "";

        if (task instanceof ToDo) {
            typeCode = "T";
        } else if (task instanceof Deadline) {
            typeCode = "D";
            extraData = " | " + ((Deadline) task).getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        } else if (task instanceof Event) {
            typeCode = "E";
            extraData = " | " + ((Event) task).getStart().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"))
                    + " | " + ((Event) task).getEnd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        }

        return typeCode + " | " + (task.isDone() ? "1" : "0") + " | " + task.getDescription() + extraData;
    }

    /**
     * Deserializes a task from a string format.
     *
     * @param line The string representation of the task.
     * @return The deserialized task, or {@code null} if parsing fails.
     */
    private Task deserializeTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            if (parts.length < 3) {
                System.out.println("WARNING: Skipping invalid task format! " + line);
                return null;
            }

            String typeCode = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];

            Task task;
            switch (typeCode) {
                case "T":
                    task = new ToDo(description);
                    break;
                case "D":
                    task = new Deadline(description, parts[3]);
                    break;
                case "E":
                    task = new Event(description, parts[3], parts[4]);
                    break;
                default:
                    return null;
            }

            if (isDone) task.markAsDone();
            return task;
        } catch (Exception e) {
            System.out.println("WARNING: Error parsing task! " + line);
            return null;
        }
    }
}
