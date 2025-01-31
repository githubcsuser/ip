package taskmax.ui;

import java.util.Scanner;

/**
 * Handles user interaction for the Taskmax application.
 */
public class Ui {
    private final Scanner scanner;
    public static final String LINE = "-".repeat(100) + "\n";

    /**
     * Constructs a Ui instance to handle user input and output.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message, including an introduction and the mascot.
     */
    public void showWelcome() {
        String intro = "Greetings! I'm Taskmax, Your personal tasking companion.\n"
                + "What can I schedule for you today?\n";
        System.out.println(LINE + intro + LINE + new Mascot() + LINE
                + "\nEnter \"hello!\" to begin\n" + LINE);
    }

    /**
     * Reads and returns a user command from the input.
     *
     * @return The user command as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays a message formatted with separator lines.
     *
     * @param message The message to display.
     */
    public void showMessage(String message) {
        System.out.println(LINE + message + "\n" + LINE);
    }

    /**
     * Displays an error message when tasks fail to load.
     */
    public void showLoadingError() {
        showMessage("Error loading tasks. Starting with an empty list.");
    }

    /**
     * Displays an error message.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Closes the scanner to release system resources.
     */
    public void close() {
        scanner.close();
    }
}
