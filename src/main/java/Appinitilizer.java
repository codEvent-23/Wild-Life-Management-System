import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Appinitilizer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/loadingForm.fxml"));
        load.setStyle("-fx-background-color: transparent;");
        Scene scene = new Scene(load, 820, 683, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        Image image = new Image(getClass().getResourceAsStream("/image/icon.png"));
        stage.getIcons().add(image);
        stage.setTitle("Wildlife Management System - Loading Page");
        stage.centerOnScreen();
        stage.show();
    }
}
