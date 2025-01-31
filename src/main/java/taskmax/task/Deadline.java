package taskmax.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task that has a specific due date and time.
 */
public class Deadline extends Task {
    private LocalDateTime dateTime;

    /**
     * Constructs a Deadline task with a description and a due date.
     *
     * @param description   The description of the deadline task.
     * @param dateTimeString The due date and time in the format "yyyy-MM-dd HHmm".
     */
    public Deadline(String description, String dateTimeString) {
        super(description, TaskType.DEADLINE);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.dateTime = LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * Returns the due date and time of the deadline task.
     *
     * @return The due date and time as a {@code LocalDateTime} object.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Returns the string representation of the deadline task, including its formatted due date.
     *
     * @return A string representation of the deadline task.
     */
    @Override
    public String toString() {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return "[D]" + super.toString() + " (by: " + dateTime.format(outputFormatter) + ")";
    }
}
