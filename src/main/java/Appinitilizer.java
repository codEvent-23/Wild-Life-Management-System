import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Appinitilizer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/loadingForm.fxml"));
        stage.setScene(new Scene(load));
        Image image = new Image(getClass().getResourceAsStream("/image/icons8-bird-96 (1).png"));
        stage.getIcons().add(image);
        stage.setTitle("Animal Searching Management System - Loading Page");
        stage.centerOnScreen();
        stage.show();
    }
}
