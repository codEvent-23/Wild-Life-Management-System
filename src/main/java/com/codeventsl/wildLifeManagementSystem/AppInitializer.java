package com.codeventsl.wildLifeManagementSystem;

import com.codeventsl.wildLifeManagementSystem.dto.AnimalDTO;
import com.codeventsl.wildLifeManagementSystem.model.Animal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*Parent load = FXMLLoader.load(getClass().getResource("/dashboardform.fxml"));
        stage.setTitle("Wild Life Management System");
        stage.setScene(new Scene(load));
        stage.show();*/
    }
}