import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Event extends Task {
    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String description, String startString, String endString) {
        super(description, TaskType.EVENT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        this.start = LocalDateTime.parse(startString, formatter);
        this.end = LocalDateTime.parse(endString, formatter);
    }

    @Override
    public String toString() {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return "[E]" + super.toString() + "(from: " + start.format(outputFormatter) + " to: " + end.format(outputFormatter) + ")";
    }
}
