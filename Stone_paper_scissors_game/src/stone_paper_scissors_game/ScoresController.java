/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package stone_paper_scissors_game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ScoresController implements Initializable {

    @FXML
    private TableColumn<LoginUser, Integer> rank;
    @FXML
    private TableColumn<LoginUser, String> name;
    @FXML
    private TableColumn<LoginUser, String> email;
    @FXML
    private TableColumn<LoginUser, Integer> max;
    @FXML
    private TableColumn<LoginUser, String> date;
    @FXML
    private TableView<LoginUser> score_table;

    /**
     * Initializes the controller class.
     */
    private Connection conn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Database db = new Database();
        conn = db.getConnnection();
        for(LoginUser u:db.getUsers()){
            System.out.println(u.getEmail());
            System.out.println(u.getName());
        }
      name.setCellValueFactory(new PropertyValueFactory<>("name"));
      email.setCellValueFactory(new PropertyValueFactory<>("email"));
      rank.setCellValueFactory(new PropertyValueFactory<>("rank"));
      max.setCellValueFactory(new PropertyValueFactory<>("max"));
      date.setCellValueFactory(new PropertyValueFactory<>("date"));
      score_table.setItems(db.getUsers());
      score_table.refresh();
        
    }    

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginSuccess.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
    }
    
}
