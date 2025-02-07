package taskmax.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Custom control representing dialog boxes.
 */
public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    /**
     * Constructor for a dialog box.
     *
     * @param message The text message.
     * @param img The display image.
     * @param bgColor The background color for the message bubble.
     */
    private DialogBox(String message, Image img, String bgColor) {
        text = new Label(message);
        text.setWrapText(true);
        text.setMaxWidth(600);
        text.setPadding(new Insets(10));
        text.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 15px;");

        // Wrap text inside a VBox with background styling
        VBox textContainer = new VBox(text);
        textContainer.setPadding(new Insets(10));
        textContainer.setStyle("-fx-background-color: " + bgColor + "; " +
                "-fx-background-radius: 12px; " +
                "-fx-padding: 10px; " +
                "-fx-font-size: 15px;");

        displayPicture = new ImageView(img);
        displayPicture.setFitWidth(60);
        displayPicture.setFitHeight(60);
        displayPicture.setPreserveRatio(true);

        this.setSpacing(15);
        this.setPadding(new Insets(10, 15, 10, 15));
        this.setMinHeight(Region.USE_PREF_SIZE);

        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(textContainer, displayPicture);
    }

    /**
     * Flips dialog so the image appears on the left.
     */
    private void flip() {
        ObservableList<Node> nodes = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(nodes);
        getChildren().setAll(nodes);
        setAlignment(Pos.TOP_LEFT);
    }

    /**
     * Returns a dialog box for user messages.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, "#a8c6ed"); // Light blue for user messages
    }

    /**
     * Returns a dialog box for Taskmax's responses.
     */
    public static DialogBox getTaskDialog(String text, Image img) {
        DialogBox db = new DialogBox(text, img, "#D6E0FF"); // Soft gray for Taskmax responses
        db.flip();
        return db;
    }
}