package taskmax.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import taskmax.ui.MainWindow;

/**
 * The main entry point for Taskmax's GUI.
 */
public class Main extends Application {
    private Taskmax taskmax = new Taskmax("data/tasks.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
            AnchorPane root = fxmlLoader.load();

            MainWindow controller = fxmlLoader.getController();
            controller.setTaskmax(taskmax);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Taskmax");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}