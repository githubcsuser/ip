package taskmax.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import taskmax.main.Taskmax;
import javafx.scene.image.Image;

/**
 * Controller for MainWindow. Provides the layout for the main UI.
 */
public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Taskmax taskmax;

    private Image userImage = new Image(getClass().getResourceAsStream("/images/User.png"));
    private Image taskImage = new Image(getClass().getResourceAsStream("/images/taskmax.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        userInput.setOnAction(event -> handleUserInput()); // Enable Enter key to send messages
    }

    public void setTaskmax(Taskmax taskmax) {
        this.taskmax = taskmax;
    }

    /**
     * Handles user input.
     * Creates two dialog boxes, one for user input and one for Taskmax’s response.
     */
    @FXML
    private void handleUserInput() {
        System.out.println("Send button clicked!"); // Debugging print statement
        String input = userInput.getText();
        System.out.println("User input: " + input); // Debug: Check if input is captured

        if (!input.isEmpty()) {
            String response = taskmax.getResponse(input);
            System.out.println("Bot response: " + response); // Debug: Check if response is generated

            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getTaskDialog(response, taskImage)
            );
            System.out.println("Messages added to dialog container!"); // Debug: Check if messages are added

            userInput.clear();
        }
    }
}