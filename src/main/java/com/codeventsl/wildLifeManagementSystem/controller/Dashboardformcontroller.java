package com.codeventsl.wildLifeManagementSystem.controller;

import com.codeventsl.wildLifeManagementSystem.dto.Location;
import com.codeventsl.wildLifeManagementSystem.model.Animal;
import com.jfoenix.controls.JFXButton;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Dashboardformcontroller implements Initializable {
    @FXML
    private TextField textFeild;

    private WebEngine webEngine;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private WebView webView;

    private String apiKey = "AIzaSyBIkRBwLozPBlqhe8xx8rXlUQcpUszeIY0";

    @FXML
    void searchBtnOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        /*String name = textFeild.getText();
        ArrayList<Location> locations = Animal.searchAnimalId(name);

        StringBuilder jsArray = new StringBuilder("[");
        for (Location location : locations) {
            jsArray.append("{lat: ").append(location.getLatitude()).append(", lng: ").append(location.getLongitude()).append("},");
        }
        jsArray.append("]");

        // Execute JavaScript to pass the array to HTML after the page is loaded
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                webEngine.executeScript("showLocations(" + jsArray.toString() + ")");
            }
        });

        // Load an initial map (you may change this depending on your requirements)
        String htmlFile = getClass().getResource("/index.html").toExternalForm();
        webEngine.load(htmlFile);*/
    }

    @FXML
    void textFeildOnActon(ActionEvent event) {
        searchBtn.fire();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* // Initialize the WebEngine
        webEngine = webView.getEngine();*/
    }
}
