package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public Button btnManageAnimal;

    boolean formOpened = false;
    @FXML
    void manageAnimalBtnOnAction(ActionEvent event) throws IOException {
        if (!formOpened) {
            openAnimalForm();
        }
    }

    private void openAnimalForm() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/animalForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Wildlife Management System - Animal Page");

        formOpened = true;
        stage.setOnCloseRequest(e -> {
            formOpened = false;
            btnManageAnimal.setDisable(false);
        });
    }
}
