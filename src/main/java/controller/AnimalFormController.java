package controller;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entity.Animal;
import entity.Location;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AnimalModel;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AnimalFormController implements Initializable {
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
    private JFXTextField txtLifeTime;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXTextField txtRegion;

    @FXML
    private JFXTextField txtConservationStatus;

    @FXML
    private JFXTextField txtReproduction;

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
    private JFXComboBox<String> cmbLocation;

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

    private final List<String> selectedLocations = new ArrayList<>();

    private static final Pattern intPattern = Pattern.compile("^[1-9][0-9]?$|^100$");

    private static final Pattern doublePattern = Pattern.compile("^[0-9]+\\.?[0-9]*$");

    private DashboardFormController dashboardFormController;

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
        if (validateFields(txtAnimalId, txtSpecies, txtCommonName, txtScientificName, txtGender,
                txtLifeTime, txtWeight, txtRegion, txtConservationStatus, txtReproduction, txtColor,
                txtMarkings, txtHabitat, txtBehavior, txtDietaryPreferences, txtAdditionalDetails)) {
            if (intPattern.matcher(txtLifeTime.getText()).matches()) {
                if (doublePattern.matcher(txtWeight.getText()).matches()) {
                    if (images.size() == 3) {
                        if (!selectedLocations.isEmpty()) {

                            List<Location> locations = geocodeLocations();
                            if (AnimalModel.saveAnimal(new Animal(
                                    txtAnimalId.getText(),
                                    txtSpecies.getText(),
                                    txtCommonName.getText(),
                                    txtScientificName.getText(),
                                    txtGender.getText(),
                                    Integer.parseInt(txtLifeTime.getText()),
                                    Double.parseDouble(txtWeight.getText()),
                                    txtRegion.getText(),
                                    txtConservationStatus.getText(),
                                    txtReproduction.getText(),
                                    txtColor.getText(),
                                    txtMarkings.getText(),
                                    txtHabitat.getText(),
                                    txtBehavior.getText(),
                                    txtDietaryPreferences.getText(),
                                    txtAdditionalDetails.getText(),
                                    images,
                                    locations
                            ))) {

                                new Alert(Alert.AlertType.CONFIRMATION, "Animal saved sucessfully!").show();
                                Stage stage = (Stage) txtAnimalId.getScene().getWindow();
                                stage.close();

                            } else {
                                new Alert(Alert.AlertType.WARNING, "Animal saved unsuccessfully!").show();
                            }
                        }else {
                            new Alert(Alert.AlertType.WARNING, "Please add locations.").show();
                        }
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Please upload 3 images.").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Average Weight should be a number.").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Average Lifetime should be a integer.").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please fill in all fields.").show();
        }
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        if (!txtSearch.getText().isEmpty()) {
            dashboardFormController.searchByAnimalForm(txtSearch.getText());
            Stage stage = (Stage) txtAnimalId.getScene().getWindow();
            stage.hide();
        } else {
            new Alert(Alert.AlertType.WARNING, "Please enter the name of animal").show();
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        searchBtnOnAction(event);
    }

    @FXML
    void addLocationBtnOnAction(ActionEvent event) {
        String selectedLocation = cmbLocation.getSelectionModel().getSelectedItem();
        if (selectedLocation != null) {
            if (!selectedLocations.contains(selectedLocation)) {
                selectedLocations.add(selectedLocation);
                new Alert(Alert.AlertType.CONFIRMATION, selectedLocation + " added to Locations.").show();
            } else {
                new Alert(Alert.AlertType.WARNING, selectedLocation + "already added to Locations.").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please select a location").show();
        }
    }

    private List<Location> geocodeLocations() {
        Dotenv dotenv = Dotenv.configure().load();
        List<Location> locations = new ArrayList<>();

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(dotenv.get("GOOGLE_MAPS_API_KEY"))
                .build();

        for (String location : selectedLocations) {
            try {
                GeocodingResult[] results = GeocodingApi.geocode(context, location).await();

                if (results.length > 0) {
                    LatLng latLng = results[0].geometry.location;
                    double latitude = latLng.lat;
                    double longitude = latLng.lng;

                    locations.add(new Location(location, latitude, longitude));
                } else {
                    new Alert(Alert.AlertType.WARNING, "Didn't find the location for " + location).show();
                }
            } catch (ApiException | InterruptedException | IOException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Google Maps API error").show();
            }
        }
        System.out.println(locations);
        return locations;
    }

    private void handleImageUpload(ImageView imageView, JFXButton button) {
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

    private boolean validateFields(TextInputControl... fields) {
        for (TextInputControl field : fields) {
            if (field.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setController(DashboardFormController dashboardFormController) {
        this.dashboardFormController = dashboardFormController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> countries = FXCollections.observableArrayList(
                "United States", "Canada", "Mexico", "Brazil", "Argentina",
                "United Kingdom", "France", "Germany", "Italy", "Spain",
                "China", "Japan", "India", "South Korea", "Australia",
                "Russia", "South Africa", "Egypt", "Nigeria", "Kenya",
                "Saudi Arabia", "United Arab Emirates", "Turkey", "Iran", "Israel",
                "Sweden", "Norway", "Denmark", "Netherlands", "Switzerland"
        );
        cmbLocation.setItems(countries);
    }
}
