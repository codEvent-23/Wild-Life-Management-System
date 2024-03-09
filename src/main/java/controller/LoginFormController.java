package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Amil Srinath
 */
public class LoginFormController {

    public Button btnAdmin;
    public Button btnUser;

    public void btnAdminOnAction(ActionEvent actionEvent) throws IOException {
        Parent loginParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/dashboardForm.fxml")));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage) btnAdmin.getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dashboardForm.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);

        DashboardFormController controller = loader.getController();
        controller.setUser();

        Stage window = (Stage) btnUser.getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
