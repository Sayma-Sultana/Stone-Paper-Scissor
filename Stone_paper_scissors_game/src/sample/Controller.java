/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Controller implements Initializable {

    @FXML
    private Label playerScore;
    @FXML
    private Label botScore;
    @FXML
    private Button stoneBtn;
    @FXML
    private Button paperBtn;
    @FXML
    private Button scissorBtn;
    @FXML
    private ImageView player;
    @FXML
    private Label result;
    @FXML
    private ImageView bot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playerTurn(ActionEvent event) {
    }
    
}
