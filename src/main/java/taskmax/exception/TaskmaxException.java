package taskmax.exception;

/**
 * Represents an exception specific to the Taskmax application.
 */
public class TaskmaxException extends Exception {

    /**
     * Constructs a {@code TaskmaxException} with the specified error message.
     *
     * @param message The error message describing the exception.
     */
    public TaskmaxException(String message) {
        super(message);
    }
}
