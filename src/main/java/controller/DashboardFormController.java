package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Controller class for the DashboardForm.fxml
public class DashboardFormController implements Initializable {

    public ImageView imgDashboardLogo;
    public Button btnLogout;
    public AnchorPane dashboardForm;
    public Label lblDetails;
    public Label lblAnimalName;
    public AnchorPane detailsPane;
    public HBox mapHBox;
    public HBox CommonLocationHBox;
    public HBox imgHBox;
    public VBox mainVBox;
    public ScrollPane mainScrollPane;
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
        animalDetailsAnchorPane.setVisible(true);
        mainVBox.getChildren().clear();

        Label tital = new Label("(Animal Name)");
        tital.setFont(new Font("Poppins", 20));

        Label detail = new Label("\n"+"The Wildlife Management System employs JavaFX and MongoDB, leveraging " +
                "Object-Oriented Programming for seamless information management of diverse wildlife species. With " +
                "a user-friendly interface, it offers a loading page, a dynamic dashboard for searching and managing " +
                "animals, detailed information retrieval, and image recognition capabilities.\n\nThe Wildlife Management " +
                "System employs JavaFX and MongoDB, leveraging Object-Oriented Programming for seamless information " +
                "management of diverse wildlife species. With a user-friendly interface, it offers a loading page, a " +
                "dynamic dashboard for searching and managing animals, detailed information retrieval, and image " +
                "recognition capabilities.\n\nThe Wildlife Management System employs JavaFX and MongoDB, leveraging " +
                "Object-Oriented Programming for seamless information management of diverse wildlife species. With a " +
                "user-friendly interface, it offers a loading page, a dynamic dashboard for searching and managing " +
                "animals, detailed information retrieval, and image recognition capabilities.\n\nThe Wildlife Management " +
                "System employs JavaFX and MongoDB, leveraging Object-Oriented Programming for seamless information " +
                "management of diverse wildlife species. With a user-friendly interface, it offers a loading page, " +
                "a dynamic dashboard for searching and managing animals, detailed information retrieval, and image " +
                "recognition capabilities.");
        detail.setWrapText(true);
        detail.setTextAlignment(TextAlignment.JUSTIFY);
        detail.setFont(new Font("Calibri", 16));

        HBox hBox = new HBox();
        mainVBox.setPadding(new Insets(20, 30, 20, 20));
        hBox.getChildren().add(detail);

        mainVBox.getChildren().addAll(imgHBox, CommonLocationHBox, mapHBox, tital, hBox);
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

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Parent loginForm = FXMLLoader.load(getClass().getResource("/view/loginForm.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loginForm));
        stage.centerOnScreen();
        stage.show();
        dashboardForm.getScene().getWindow().hide();
    }

    public void closeOnMouseClicked(MouseEvent mouseEvent) {
        animalDetailsAnchorPane.setVisible(false);
    }
}
