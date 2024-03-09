package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Controller class for the DashboardForm.fxml
public class DashboardFormController implements Initializable {

    public ImageView imgDashboardLogo;
    // Reference to the AnchorPane defined in the FXML file
    @FXML
    private AnchorPane animalDetailsAnchorPane;

    // Reference to the "Manage Animal" button defined in the FXML file
    @FXML
    private Button btnManageAnimal;

    // Flag to track whether the animal form is opened or not
    private boolean formOpened = false;

    // Method called when the "Manage Animal" button is clicked
    @FXML
    void manageAnimalBtnOnAction(ActionEvent event) throws IOException {
        // Check if the form is not already opened
        if (!formOpened) {
            // Open the Animal Form
            openAnimalForm();
        }
    }

    // Method to open the Animal Form
    private void openAnimalForm() throws IOException {
        // Load the Animal Form FXML file
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/animalForm.fxml"));
        // Create a new stage for the Animal Form
        Stage stage = new Stage();
        // Set the scene for the Animal Form stage
        stage.setScene(new Scene(anchorPane));
        // Show the Animal Form stage
        stage.show();
        // Center the Animal Form stage on the screen
        stage.centerOnScreen();
        // Set the title for the Animal Form stage
        stage.setTitle("Wildlife Management System - Animal Page");

        // Update the formOpened flag and set an event handler for when the Animal Form stage is closed
        formOpened = true;
        stage.setOnCloseRequest(e -> {
            formOpened = false;
            // Re-enable the "Manage Animal" button when the Animal Form stage is closed
            btnManageAnimal.setDisable(false);
        });
    }

    // Method called when the "Upload Image" button is clicked
    @FXML
    void uploadImgBtnOnAction(ActionEvent event) {
        // Make the animalDetailsAnchorPane visible
        animalDetailsAnchorPane.setVisible(true);
    }

    // Method called during the initialization of the controller
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the animalDetailsAnchorPane to be initially invisible
        animalDetailsAnchorPane.setVisible(false);
    }

    public void setUser() {
        btnManageAnimal.setVisible(false);
        imgDashboardLogo.setY(30);
    }
}
