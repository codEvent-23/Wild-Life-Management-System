package controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingFormController implements Initializable {
    @FXML
    private ProgressBar progressgBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    updateProgress(i,55);
                    Thread.sleep(55);
                }
                return null;
            }
        };

        progressgBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(event -> {

            Parent loginParent = null;
            try {
                loginParent = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
                Scene loginScene = new Scene(loginParent);
                Stage loginStage = new Stage();
                loginStage.setResizable(false);
                Image image = new Image(getClass().getResourceAsStream("/image/icon.png"));
                loginStage.getIcons().add(image);
                loginStage.setTitle("Wildlife Management System - Dashboard Page");
                loginStage.setScene(loginScene);
                loginStage.show();
                ((Stage)progressgBar.getScene().getWindow()).close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        new Thread(task).start();
    }
}
