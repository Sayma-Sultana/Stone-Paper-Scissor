/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stone_paper_scissors_game;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginSuccessController implements Initializable {

    @FXML
    private Button playbtn;
    @FXML
    private Button scores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playbtnmethod(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GamePage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    @FXML
    private void handleScore(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scores.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage)(((Node)event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    @FXML
    private void handleQuit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
                        alert.setTitle("Are you sure?");
        alert.setHeaderText("Do you really want to quit this game? we will miss you");
                Optional<ButtonType> r = alert.showAndWait();
                        if (r.isPresent()) {
            if (r.get() == ButtonType.OK) {
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.close();
                        }
                    }
    }
    
}
