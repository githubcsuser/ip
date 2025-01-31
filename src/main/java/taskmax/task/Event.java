package taskmax.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task that has a start and end date/time.
 */
public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param startString The start date and time in the format "yyyy-MM-dd HHmm".
     * @param endString   The end date and time in the format "yyyy-MM-dd HHmm".
     */
    public Event(String description, String startString, String endString) {
        super(description, TaskType.EVENT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.start = LocalDateTime.parse(startString, formatter);
        this.end = LocalDateTime.parse(endString, formatter);
    }

    /**
     * Returns the start date and time of the event.
     *
     * @return The start date and time as a {@code LocalDateTime} object.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Returns the end date and time of the event.
     *
     * @return The end date and time as a {@code LocalDateTime} object.
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * Returns the string representation of the event task, including formatted start and end times.
     *
     * @return A string representation of the event task.
     */
    @Override
    public String toString() {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return "[E]" + super.toString() + " (from: " + start.format(outputFormatter) + " to: " + end.format(outputFormatter) + ")";
    }
}
