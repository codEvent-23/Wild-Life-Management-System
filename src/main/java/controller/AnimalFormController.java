package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AnimalFormController {
    @FXML
    private JFXTextField txtAnimalId;

    @FXML
    private JFXTextField txtSpecies;

    @FXML
    private JFXTextField txtCommonName;

    @FXML
    private JFXTextField txtScientificName;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXTextField lifeTime;

    @FXML
    private JFXTextField weight;

    @FXML
    private JFXTextField region;

    @FXML
    private JFXTextField conservationStatus;

    @FXML
    private JFXTextField reProduction;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtMarkings;

    @FXML
    private JFXTextField txtHabitat;

    @FXML
    private JFXTextField txtBehavior;

    @FXML
    private JFXTextField txtDietaryPreferences;

    @FXML
    private JFXComboBox<?> cmbLocation;

    @FXML
    private JFXTextArea txtAdditionalDetails;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private JFXButton imageUploadBtn1;

    @FXML
    private JFXButton imageUploadBtn2;

    @FXML
    private JFXButton imageUploadBtn3;

    @FXML
    private JFXTextField txtSearch;

    private final List<byte[]> images = new ArrayList<>();

    @FXML
    void ImageUpload1OnAction(ActionEvent event) {
        handleImageUpload(image1, imageUploadBtn1);
    }

    @FXML
    void ImageUpload2OnAction(ActionEvent event) {
        handleImageUpload(image2, imageUploadBtn2);
    }

    @FXML
    void ImageUpload3OnAction(ActionEvent event) {
        handleImageUpload(image3, imageUploadBtn3);
    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {

    }

    private void handleImageUpload(ImageView imageView, JFXButton button){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png")
        );
        File selectedFile = fileChooser.showOpenDialog(txtAnimalId.getScene().getWindow());

        if (selectedFile != null) {
            try {
                byte[] data = Files.readAllBytes(selectedFile.toPath());
                imageView.setImage(new Image(new ByteArrayInputStream(data)));
                button.setVisible(false);

                images.add(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
