package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    @FXML
    void manageAnimalBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/animalForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Wildlife Management System - Animal Page");
    }
}
